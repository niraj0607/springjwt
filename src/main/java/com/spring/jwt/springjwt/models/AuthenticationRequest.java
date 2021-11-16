package com.spring.jwt.springjwt.models;

import java.io.Serializable;

public class AuthenticationRequest implements Serializable {


    private String id;
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //need default constructor for JSON Parsing
    public AuthenticationRequest()
    {

    }

    public AuthenticationRequest(String id, String password) {
        this.setId(id);
        this.setPassword(password);
    }
}
