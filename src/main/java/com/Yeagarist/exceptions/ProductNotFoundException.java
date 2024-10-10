package com.Yeagarist.exceptions;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException() {

        // enum for this message
        super(ErrorMessages.PRODUCT_NOT_FOUND.getMessage());
    }
}
