package com.Yeagarist.product.model;

import lombok.Getter;

@Getter
public class ErrorResponse {

    // can make your error messages as big as you want with more properties
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
