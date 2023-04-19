package com.validations;

public class ValidationException extends RuntimeException {
    private static final long serialVersionUID = -6874215221854343L;
    private int code;
    private String message;

    public ValidationException(String message) {
        super(message);
        this.message = message;
    }

    public ValidationException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

