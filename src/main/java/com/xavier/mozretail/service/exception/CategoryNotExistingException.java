package com.xavier.mozretail.service.exception;

import org.springframework.http.HttpStatus;

public class CategoryNotExistingException extends BusnessException {
    public CategoryNotExistingException() {
        super("category-3", HttpStatus.BAD_REQUEST);
    }
}
