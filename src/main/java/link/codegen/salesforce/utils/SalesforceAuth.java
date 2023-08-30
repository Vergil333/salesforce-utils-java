package link.codegen.salesforce.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.ZonedDateTime;

public class SalesforceAuth {

    private String refreshToken = "yourRefreshToken";

    private String accessToken;
    public String getAccessToken() throws IOException {
        if (!isValid()) update();
        return this.accessToken;
    }

    private String instanceUrl;
    public String getInstanceUrl() {
        return instanceUrl;
    }

    private ZonedDateTime validUntil;
    private final ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    public SalesforceAuth() throws IOException {
        AuthResponse response = refreshAccessToken();
        this.accessToken = response.getAccessToken();
        this.instanceUrl = response.getInstanceUrl();
        this.validUntil = ZonedDateTime.now().plusHours(2).minusMinutes(5);
    }

    public SalesforceAuth(String refreshToken) throws IOException {
        this.refreshToken = refreshToken;
        AuthResponse response = refreshAccessToken();
        this.accessToken = response.getAccessToken();
        this.instanceUrl = response.getInstanceUrl();
        this.validUntil = ZonedDateTime.now().plusHours(2).minusMinutes(5);
    }

    private void update() throws IOException {
        AuthResponse response = refreshAccessToken();
        this.accessToken = response.getAccessToken();
        this.instanceUrl = response.getInstanceUrl();
        this.validUntil = ZonedDateTime.now().plusHours(2).minusMinutes(5);
    }

    private AuthResponse refreshAccessToken() throws IOException {

        URL url = new URL("https://api.codegen.link/salesforce/login/refresh");
        HttpURLConnection connection = ((HttpURLConnection) url.openConnection());
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        AuthRequest requestBody = new AuthRequest(this.refreshToken);
        new DataOutputStream(connection.getOutputStream())
                .writeBytes(mapper.writeValueAsString(requestBody));

        return mapper.readValue(connection.getInputStream(), AuthResponse.class);
    }

    private Boolean isValid() {
        return this.validUntil.isAfter(ZonedDateTime.now());
    }
}
