package com.Yeagarist.exceptions;

public enum ErrorMessages {
    PRODUCT_NOT_FOUND("product not found");
    // Where all my messages are located

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
