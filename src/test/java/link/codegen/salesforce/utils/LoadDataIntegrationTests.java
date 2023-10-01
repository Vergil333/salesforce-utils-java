package link.codegen.salesforce.utils;

import link.codegen.salesforce.objects.Account;
import link.codegen.salesforce.objects.TestObject__c;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

class LoadDataIntegrationTests {

    public LoadDataIntegrationTests() throws IOException {}

    // real refreshToken is placed here when testing
    private final SalesforceAuth auth = new SalesforceAuth("real-testing-token");
    private final SalesforceClient client = new SalesforceClient(auth);

    // Account tests
    @Test
    void loadAllAccounts() throws IOException, URISyntaxException {

        SfResponse<Account> response = client.getAll(Account.class);

        Assertions.assertEquals(13, response.getTotalSize());
    }

    @Test
    void loadAllAccountNames() throws IOException, URISyntaxException {
        List<String> expectedAccountNames = Stream.of(
                "University of Arizona",
                "GenePoint",
                "United Oil & Gas, Singapore",
                "Grand Hotels & Resorts Ltd",
                "United Oil & Gas Corp.",
                "Pyramid Construction Inc.",
                "sForce",
                "Burlington Textiles Corp of America",
                "Express Logistics and Transport",
                "Edge Communications",
                "Sample Account for Entitlements",
                "United Oil & Gas, UK",
                "Dickenson plc"
        ).sorted().toList();

        SfResponse<Account> response = client.getAll(Account.class);
        List<String> accountNames = response.getRecords().stream().map(Account::getName).sorted().toList();

        Assertions.assertArrayEquals(expectedAccountNames.toArray(), accountNames.toArray());
    }

    @Test
    void testZonedDateTimeDeserialization() throws IOException, URISyntaxException {
        ZonedDateTime expectedZonedDateTime = ZonedDateTime.of(2022, 2, 14, 11, 18, 50, 0, ZoneOffset.UTC);

        SfResponse<Account> response = client.getAll(Account.class);
        ZonedDateTime actualZonedDateTime = response.getRecords().stream()
                .filter(account -> Objects.equals(account.getName(), "sForce"))
                .findFirst().get()
                .getCreatedDate();

        Assertions.assertEquals(expectedZonedDateTime, actualZonedDateTime);
    }

    @Test
    void testLocalDateDeserialization() throws IOException, URISyntaxException {
        LocalDate expectedLocalDate = LocalDate.of(2022, 9, 11);

        SfResponse<Account> response = client.getAll(Account.class);
        LocalDate actualLocalDate = response.getRecords().stream()
                .filter(account -> Objects.equals(account.getName(), "GenePoint"))
                .findFirst().get()
                .getSLAExpirationDate__c();

        Assertions.assertEquals(expectedLocalDate, actualLocalDate);
    }

    @Disabled("Account doesn't have Time field, so skip this one")
    @Test
    void testLocalTimeDeserialization() throws IOException, URISyntaxException {
        LocalTime expectedLocalTime = LocalTime.of(1, 1, 1);

        SfResponse<Account> response = client.getAll(Account.class);
//        LocalTime actualLocalTime = response.getRecords().stream()
        LocalTime actualLocalTime = LocalTime.of(1, 1, 1);

        Assertions.assertEquals(expectedLocalTime, actualLocalTime);
    }

    // Custom object tests
    @Test
    void loadAllCustomObject() throws IOException, URISyntaxException {

        SfResponse<TestObject__c> response = client.getAll(TestObject__c.class);

        Assertions.assertEquals(1, response.getTotalSize());
    }
}
