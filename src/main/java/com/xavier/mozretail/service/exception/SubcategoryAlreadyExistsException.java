package com.xavier.mozretail.service.exception;

import org.springframework.http.HttpStatus;

public class SubcategoryAlreadyExistsException extends BusnessException {
    public SubcategoryAlreadyExistsException() {
        super("subcategory-3", HttpStatus.BAD_REQUEST);
    }
}
