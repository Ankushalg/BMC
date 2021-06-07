package com.allstudio.bmc.Objects;

public class User {
    private String email, token;

    public User() { }

    public User(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
