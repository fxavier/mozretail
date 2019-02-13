package com.xavier.mozretail.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


import com.xavier.mozretail.model.Category;
import com.xavier.mozretail.repository.CategoryRepository;
import com.xavier.mozretail.service.exception.CategoryExistsException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.mockito.Mockito.when;

public class CategoryServiceTest {

    private CategoryService categoryService;

    @Mock
    private CategoryRepository mockedCategory;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryService(mockedCategory);
    }

    @Test(expected = CategoryExistsException.class)
    public void should_deny_category_that_exists() {
        Category categoryInDatabase = new Category();
        categoryInDatabase.setId(10L);
        categoryInDatabase.setName("Test");
        when(mockedCategory.findByNameIgnoreCase("Test")).thenReturn(Optional.of(categoryInDatabase));
        Category newCategory = new Category();
        newCategory.setName("Test");

        categoryService.save(newCategory);

    }

    @Test
    public void should_create_new_category() {
        Category newCategory = new Category();
        newCategory.setName("Test");
        Category newCategoryInDatabase = new Category();
        newCategoryInDatabase.setId(10L);
        newCategoryInDatabase.setName("Test");
        when(mockedCategory.save(newCategory)).thenReturn(newCategoryInDatabase);
        Category savedCategory = categoryService.save(newCategory);
        assertThat(savedCategory.getName(), equalTo("Test"));

    }

}
