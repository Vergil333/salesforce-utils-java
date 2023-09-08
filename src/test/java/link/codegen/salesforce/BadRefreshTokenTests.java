package link.codegen.salesforce;

import link.codegen.salesforce.utils.SalesforceAuth;
import link.codegen.salesforce.utils.SalesforceClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

class BadRefreshTokenTests {

    public BadRefreshTokenTests() {
    }

    @Test
    void DemoTokenReturnsSpecificMessage() {
        String refreshToken = "demoRefreshToken";

        IllegalArgumentException actualException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new SalesforceAuth(refreshToken)
        );

        Assertions.assertTrue(actualException.getMessage().contains("demoRefreshToken"));
        Assertions.assertFalse(actualException.getMessage().startsWith("Unexpected error occurred"));
    }

    @Test
    void InvalidTokenReturnsSpecificMessage() {
        String refreshToken = "invalidRefreshToken";

        IllegalArgumentException actualException = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> new SalesforceAuth(refreshToken)
        );

        Assertions.assertTrue(actualException.getMessage().contains("expired access/refresh token"));
        Assertions.assertFalse(actualException.getMessage().startsWith("Unexpected error occurred"));
    }

    @Test
    void ValidToken() throws IOException {
        String refreshToken = "put-testing-refresh-token-here";

        SalesforceAuth auth = new SalesforceAuth(refreshToken);

        Assertions.assertNotNull(auth.getAccessToken());
        Assertions.assertNotNull(auth.getInstanceUrl());
    }
}
