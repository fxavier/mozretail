package com.xavier.mozretail.service.exception;

import org.springframework.http.HttpStatus;

public class CategoryExistsException extends BusnessException {

    public CategoryExistsException() {
        super("category-2", HttpStatus.BAD_REQUEST);
    }
}
