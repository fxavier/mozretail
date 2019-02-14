package com.xavier.mozretail.service;

import com.xavier.mozretail.model.Brand;
import com.xavier.mozretail.repository.BrandRepository;
import com.xavier.mozretail.service.exception.BrandAlreadyExistsException;
import com.xavier.mozretail.service.exception.BrandNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandService {

    private BrandRepository brandRepository;

    public BrandService(@Autowired BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    public Brand save(final Brand brand) {
        verifyIfExists(brand);
        return brandRepository.save(brand);
    }

    private void verifyIfExists(Brand brand) {
        Optional<Brand> brandByName = brandRepository.findByBrandNameIgnoreCase(brand.getBrandName());
        if(brandByName.isPresent() && (brand.isNew() || isUpdatingToADifferntBrand(brand, brandByName))) {
            throw new BrandAlreadyExistsException();
        }
    }

    private Boolean isUpdatingToADifferntBrand(Brand brand, Optional<Brand> brandByName) {
        return brand.BrandExists() && !brand.equals(brandByName.get());
    }

    public void deleta(Long id) {
        verifyIfBrandNotExists(id);
        brandRepository.deleteById(id);
    }

    private void verifyIfBrandNotExists(Long id) {
        Optional<Brand> brandById = brandRepository.findById(id);
        if (!brandById.isPresent()) {
            throw new BrandNotFoundException();
        }
    }
}
