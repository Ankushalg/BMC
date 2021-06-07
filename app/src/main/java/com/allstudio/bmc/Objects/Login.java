package com.allstudio.bmc.Objects;

public class Login {
    private String email;
    private String password;
    private long deviceID;

    public Login() { }

    public Login(String email, String password, long deviceID){
        this.deviceID = deviceID;
        this.email = email;
        this.password = password;
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

    public long getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(long deviceID) {
        this.deviceID = deviceID;
    }
}
