package link.codegen.salesforce;

import link.codegen.salesforce.utils.SalesforceAuth;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class BadRefreshTokenIntegrationTests {

    public BadRefreshTokenIntegrationTests() {
    }

    @Test
    void demoTokenReturnsSpecificMessage() {
        String refreshToken = "demoRefreshToken";

        IllegalArgumentException actualException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new SalesforceAuth(refreshToken)
        );

        Assertions.assertTrue(actualException.getMessage().contains("demoRefreshToken"));
        Assertions.assertFalse(actualException.getMessage().startsWith("Unexpected error occurred"));
    }

    @Test
    void invalidTokenReturnsSpecificMessage() {
        String refreshToken = "invalidRefreshToken";

        IllegalArgumentException actualException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new SalesforceAuth(refreshToken)
        );

        Assertions.assertTrue(actualException.getMessage().contains("expired access/refresh token"));
        Assertions.assertFalse(actualException.getMessage().startsWith("Unexpected error occurred"));
    }

    @Test
    void validToken() throws IOException {
        String refreshToken = "real-testing-token";

        SalesforceAuth auth = new SalesforceAuth(refreshToken);

        Assertions.assertNotNull(auth.getAccessToken());
        Assertions.assertNotNull(auth.getInstanceUrl());
    }
}
