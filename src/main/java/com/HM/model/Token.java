package com.HM.model;

public class Token {
    //atributo
    private final String accessToken;

    //constructor
    public Token(String accessToken) {
        this.accessToken = accessToken;
    }

    //getter
    public String getAccessToken() {
        return accessToken;
    }
}
