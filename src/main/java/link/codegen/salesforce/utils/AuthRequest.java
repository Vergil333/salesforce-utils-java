package link.codegen.salesforce.utils;

public class AuthRequest {
    private final String refreshToken;

    public AuthRequest(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }
}
