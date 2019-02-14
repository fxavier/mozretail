package com.xavier.mozretail.service;

import com.xavier.mozretail.model.Subcategory;
import com.xavier.mozretail.repository.SubcategoryRepository;
import com.xavier.mozretail.service.exception.SubcategoryAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubcategoryService {

    private SubcategoryRepository subcategoryRepository;

    public SubcategoryService(@Autowired SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    public Subcategory save(final Subcategory subcategory) {
        verifyIfSubcategoryExists(subcategory);

        return subcategoryRepository.save(subcategory);
    }

    private void verifyIfSubcategoryExists(Subcategory subcategory) {
        Optional<Subcategory> subcategoryByName = subcategoryRepository.findByName(subcategory.getName());
        if(subcategoryByName.isPresent() && subcategory.isNew()) {
            throw new SubcategoryAlreadyExistsException();
        }
    }

}
