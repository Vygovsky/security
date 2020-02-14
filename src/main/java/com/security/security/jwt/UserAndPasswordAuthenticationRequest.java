package com.security.security.jwt;

public class UserAndPasswordAuthenticationRequest {
   private String name;
   private String password;

     public UserAndPasswordAuthenticationRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
