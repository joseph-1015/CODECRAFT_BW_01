package com.example.crud_api.exception;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL) // Ignore null values in JSON output
public class ErrorResponse {
    private final int status;
    private final String error;
    private final Object message;
    private final String path;

    // Main constructor
    public ErrorResponse(int status, String error, Object message, String path) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }

    // Overloaded constructor for simpler cases (e.g., internal server errors)
    public ErrorResponse(int status, String error) {
        this(status, error, null, null);
    }

    public int getStatus() { return status; }
    public String getError() { return error; }
    public Object getMessage() { return message; }
    public String getPath() { return path; }
}
