package com.media.tecnm.market_backend_v2.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Client {

    private String clientId;
    private String firstName;
    private String lastName;
    private String cellphone;
    private String address;
    private String email;

    // Write-only: clients can send a password on create/update, but the
    // stored BCrypt hash is never serialized in API responses.
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
