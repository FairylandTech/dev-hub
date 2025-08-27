package org.example.exception;

public class ParseAgeException extends RuntimeException {
    public ParseAgeException(String message) {
        super(message);
    }
}
