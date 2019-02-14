package com.xavier.mozretail.service.exception;

import org.springframework.http.HttpStatus;

public class BrandNotFoundException extends BusnessException {
    public BrandNotFoundException() {
        super("brand-3", HttpStatus.BAD_REQUEST);
    }
}
