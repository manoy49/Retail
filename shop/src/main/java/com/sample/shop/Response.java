package com.sample.shop;

import org.springframework.http.HttpStatus;

public class Response {

    private HttpStatus status;
    private String message;
    private String errors;
    private Object data;
    public static final String DATA_NOT_FOUND = "Data Does Not Exist";
    public static final String SUCCESS = "Success";
    public static final String ERRORS = "";
    public static final String DATA_EXISTS = "Data Already Exist";

    public Response(HttpStatus status, String message, String errors, Object data) {
        this.status = status;
        this.message = message;
        this.errors = errors;
        this.data = data;
    }

    public Response() {

    }

    public HttpStatus getStatus() {
        return this.status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}