package com.example.crud.exception;

public class DepartmentNotFoundException extends RuntimeException {

    public DepartmentNotFoundException() {
        super("Department ID not found in table.");
    }

    public DepartmentNotFoundException(String message) {
        super(message);
    }
}