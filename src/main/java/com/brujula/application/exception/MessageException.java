package com.brujula.application.exception;

public class MessageException extends RuntimeException{

    private final String message;

    public MessageException(String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
