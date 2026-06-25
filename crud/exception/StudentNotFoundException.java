package com.example.crud.exception;

public class StudentNotFoundException extends RuntimeException {

    public StudentNotFoundException() {
        super("Student ID not found in table.");
    }

    public StudentNotFoundException(String message) {
        super(message);
    }
}