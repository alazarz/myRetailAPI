package com.example.myRetail.Service;

/**
 *  Class to handle the response that the API will send after PUT to the products endpoint
 */
public class ServiceResponse {

    private int statusCode;
    private String message;

    public ServiceResponse() {}
    public ServiceResponse(int statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
