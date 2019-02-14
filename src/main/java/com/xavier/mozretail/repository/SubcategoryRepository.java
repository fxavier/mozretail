package com.xavier.mozretail.repository;

import com.xavier.mozretail.model.Subcategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubcategoryRepository extends JpaRepository<Subcategory, Long> {
    public Optional<Subcategory> findByName(String name);
}
