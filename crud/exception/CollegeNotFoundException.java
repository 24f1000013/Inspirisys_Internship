package com.example.crud.exception;

public class CollegeNotFoundException extends RuntimeException {

    public CollegeNotFoundException() {
        super("College ID not found in table.");
    }

    public CollegeNotFoundException(String message) {
        super(message);
    }
}