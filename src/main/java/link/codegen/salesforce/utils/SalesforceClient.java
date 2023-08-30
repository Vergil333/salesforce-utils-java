package link.codegen.salesforce.utils;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SalesforceClient {

    public SalesforceClient() throws IOException {
        this.auth = new SalesforceAuth();
        this.mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule()
                        .addDeserializer(
                                ZonedDateTime.class,
                                InstantDeserializer.ZONED_DATE_TIME
                        )
                        .addDeserializer(
                                LocalDate.class,
                                LocalDateDeserializer.INSTANCE
                        )
                        .addDeserializer(
                                LocalTime.class,
                                new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss.SSS'Z'"))
                        ));
        this.apiVersion = "v53.0";
    }

    public SalesforceClient(SalesforceAuth auth) {
        this.auth = auth;
        this.mapper = new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .registerModule(new JavaTimeModule()
                        .addDeserializer(
                                ZonedDateTime.class,
                                InstantDeserializer.ZONED_DATE_TIME
                        )
                        .addDeserializer(
                                LocalDate.class,
                                LocalDateDeserializer.INSTANCE
                        )
                        .addDeserializer(
                                LocalTime.class,
                                new LocalTimeDeserializer(DateTimeFormatter.ofPattern("HH:mm:ss.SSS'Z'"))
                        ));
        this.apiVersion = "v53.0";
    }

    private final SalesforceAuth auth;
    private final String apiVersion;
    private final ObjectMapper mapper;

    public <T extends SObjectInterface> SfResponse<T> getAll(Class<T> clazz) throws IOException, URISyntaxException {
        String joinedFields = String.join(",", this.getFields(clazz));
        String query = "SELECT " + joinedFields + " FROM " + clazz.getSimpleName();
        return getResponse(query, clazz);
    }

    public <T extends SObjectInterface> SfResponse<T> getWhere(Class<T> clazz, String where) throws IOException, URISyntaxException {
        String joinedFields = String.join(",", this.getFields(clazz));
        String query = "SELECT " + joinedFields + " FROM " + clazz.getSimpleName() + " WHERE " + where;
        return getResponse(query, clazz);
    }

    public <T extends SObjectInterface> Integer count(Class<T> clazz) throws IOException, URISyntaxException {
        String query = "SELECT COUNT() FROM " + clazz.getSimpleName();
        return getResponse(query, clazz).getTotalSize();
    }

    private <T extends SObjectInterface> SfResponse<T> getResponse(String query, Class<T> clazz) throws IOException, URISyntaxException {
        URL url = constructUrl(query);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setRequestProperty("accept", "application/json");
        connection.setRequestProperty("Authorization", "Bearer " + auth.getAccessToken());

        JavaType wrappedResponseType = mapper.getTypeFactory().constructParametricType(SfResponse.class, clazz);

        return mapper.readValue(connection.getInputStream(), wrappedResponseType);
    }

    private URL constructUrl(String query) throws MalformedURLException, URISyntaxException {
        URL url = new URL(auth.getInstanceUrl() + "/services/data/" + apiVersion + "/query?q=" + query);
        URI uri = toUri(url);
        return uri.toURL();
    }

    /**
     * URI is used for URL encoding.
     */
    private URI toUri(URL url) throws URISyntaxException {
        return new URI(
                url.getProtocol(),
                url.getUserInfo(),
                IDN.toASCII(url.getHost()),
                url.getPort(),
                url.getPath(),
                url.getQuery(),
                url.getRef()
        );
    }

    private <T extends SObjectInterface> List<String> getFields(Class<T> clazz) {
        List<Field> fields = Arrays.stream(clazz.getFields()).filter(field -> !field.getName().equals("attributes"))
                .toList();

        List<String> jsonFields = fields.stream()
                .map(field -> field.getAnnotation(JsonProperty.class).value())
                .collect(Collectors.toList());

        return jsonFields;
    }
}
