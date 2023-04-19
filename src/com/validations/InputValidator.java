package com.validations;

public class InputValidator extends Throwable {
    public static void validateLoginAttempts(String[] args){
        if (args.length < 2) {
            throw new IllegalArgumentException("Error: Insufficient arguments for login. Please provide user ID and password.");
        }
    }
}
