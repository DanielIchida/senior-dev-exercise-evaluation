package com.brujula.infraestructure.api.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfo {

    @JsonProperty("message")
    private final String message;
    @JsonProperty("status_code")
    private final int statusCode;
    @JsonProperty("uri")
    private final String uriRequested;


    public ErrorInfo(int statusCode, String message, String uriRequested) {
        this.message = message;
        this.statusCode = statusCode;
        this.uriRequested = uriRequested;
    }

    public String getMessage() {
        return message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getUriRequested() {
        return uriRequested;
    }

}
