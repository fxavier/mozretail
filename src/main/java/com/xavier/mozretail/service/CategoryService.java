package com.xavier.mozretail.service;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.xavier.mozretail.model.Category;
import com.xavier.mozretail.repository.CategoryRepository;
import com.xavier.mozretail.service.exception.CategoryExistsException;
import com.xavier.mozretail.service.exception.CategoryNotExistingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {


    private CategoryRepository categoryRepository;

    public CategoryService(@Autowired CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(final Category category) {
        verifyIfCategoryExists(category);
        return categoryRepository.save(category);
    }

    private void verifyIfCategoryExists(final Category category) {
        Optional<Category> categoryByName = categoryRepository.findByNameIgnoreCase(category.getName());
        if(categoryByName.isPresent() && (category.isNew() || isUpdatingToADifferentCategory(category, categoryByName))) {
            throw new CategoryExistsException();
        }

    }

    private Boolean isUpdatingToADifferentCategory(Category category, Optional<Category> categoryByName) {
        return category.categoryExists() && !categoryByName.get().equals(category);
    }

    public void delete(Long id) {
        verifyIfCategoryNotExists(id);
        categoryRepository.deleteById(id);
    }

    private void verifyIfCategoryNotExists(Long id) {
        Optional<Category> categoryById = categoryRepository.findById(id);
        if(!categoryById.isPresent()) {
            throw new CategoryNotExistingException();
        }
    }


}
