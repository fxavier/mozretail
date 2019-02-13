package com.xavier.mozretail.resource;


import com.xavier.mozretail.event.ResourceCreatedEvent;
import com.xavier.mozretail.model.Brand;
import com.xavier.mozretail.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandResource {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private ApplicationEventPublisher publisher;


    @GetMapping
    public List<Brand> all() {
     return brandRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Brand> create(@Valid @RequestBody final Brand brand, HttpServletResponse response) {
        Brand savedBrand = brandRepository.save(brand);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedBrand.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBrand);

    }
}
