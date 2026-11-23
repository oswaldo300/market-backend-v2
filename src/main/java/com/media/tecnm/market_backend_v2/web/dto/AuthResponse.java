package com.media.tecnm.market_backend_v2.web.dto;

public class AuthResponse {

    private String token;
    private String clientId;

    public AuthResponse(String token, String clientId) {
        this.token = token;
        this.clientId = clientId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
