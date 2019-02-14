package com.xavier.mozretail.service;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.when;

import com.xavier.mozretail.model.Brand;
import com.xavier.mozretail.repository.BrandRepository;
import com.xavier.mozretail.service.exception.BrandAlreadyExistsException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class BrandServiceTest {

    private BrandService brandService;

    @Mock
    private BrandRepository mockedBrand;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        brandService = new BrandService(mockedBrand);
    }

    @Test(expected = BrandAlreadyExistsException.class)
    public void shouldDenyExistingBrand() {
        Brand brandInDatabase = new Brand();
        brandInDatabase.setId(5L);
        brandInDatabase.setBrandName("Apple");
        when(mockedBrand.findByBrandNameIgnoreCase("Apple"))
                .thenReturn(Optional.of(brandInDatabase));
        Brand newBrand = new Brand();
        newBrand.setId(5L);
        newBrand.setBrandName("Apple");

        brandService.save(newBrand);
    }

    @Test
    public void shouldCreateNewBrand() {
        Brand newBrand = new Brand();
        newBrand.setId(10L);
        newBrand.setBrandName("Mac");
        Brand brandInDatabase = new Brand();
        brandInDatabase.setId(10L);
        brandInDatabase.setBrandName("Mac");
        when(mockedBrand.save(newBrand)).thenReturn(brandInDatabase);
        Brand savedBrand = brandService.save(newBrand);
        assertThat(savedBrand.getId(), equalTo(10L));
        assertThat(savedBrand.getBrandName(), equalTo("Mac"));
    }
}
