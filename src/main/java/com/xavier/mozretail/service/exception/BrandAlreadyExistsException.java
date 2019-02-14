package com.xavier.mozretail.service.exception;

import org.springframework.http.HttpStatus;

public class BrandAlreadyExistsException extends BusnessException {
    public BrandAlreadyExistsException() {
        super("brand-2", HttpStatus.BAD_REQUEST);
    }
}
