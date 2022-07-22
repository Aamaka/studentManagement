package com.semicolon.studentmanagement.exceptions;

public class StudentExistException extends IllegalArgumentException {
    public StudentExistException(String message) {
        super(message);
    }
}
