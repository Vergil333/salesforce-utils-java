package link.codegen.salesforce;

import link.codegen.salesforce.objects.Account;
import link.codegen.salesforce.objects.TestObjectMM4__c;
import link.codegen.salesforce.utils.SalesforceAuth;
import link.codegen.salesforce.utils.SalesforceClient;
import link.codegen.salesforce.utils.SfResponse;
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

class LoadDataTests {

    public LoadDataTests() throws IOException {}

    // real refreshToken is placed here when testing
    private final SalesforceAuth auth = new SalesforceAuth("testingRefreshToken");
    private final SalesforceClient client = new SalesforceClient(auth);

    // Account tests
    @Test
    void loadAllAccounts() throws IOException, URISyntaxException {

        SfResponse<Account> response = client.getAll(Account.class);

        Assertions.assertEquals(13, response.getTotalSize());
    }

    @Test
    void loadAllAccountNames() throws IOException, URISyntaxException {
        List<String> expectedAccountNames = List.of(
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
        );

        SfResponse<Account> response = client.getAll(Account.class);
        List<String> accountNames = response.getRecords().stream().map(Account::getName).toList();

        Assertions.assertArrayEquals(expectedAccountNames.toArray(), accountNames.toArray());
    }

    @Test
    void testZonedDateTimeDeserialization() throws IOException, URISyntaxException {
        ZonedDateTime expectedZonedDateTime = ZonedDateTime.of(2022, 11, 25, 8, 44, 48, 0, ZoneOffset.UTC);

        SfResponse<Account> response = client.getAll(Account.class);
        ZonedDateTime actualZonedDateTime = response.getRecords().stream()
                .filter(account -> Objects.equals(account.getName(), "sForce"))
                .findFirst().get()
                .getCreatedDate();

        Assertions.assertEquals(expectedZonedDateTime, actualZonedDateTime);
    }

    @Test
    void testLocalDateDeserialization() throws IOException, URISyntaxException {
        LocalDate expectedLocalDate = LocalDate.of(2023, 6, 22);

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

        SfResponse<TestObjectMM4__c> response = client.getAll(TestObjectMM4__c.class);

        Assertions.assertEquals(1, response.getTotalSize());
    }
}
