package com.xavier.mozretail.resource;


import com.xavier.mozretail.event.ResourceCreatedEvent;
import com.xavier.mozretail.model.Brand;
import com.xavier.mozretail.repository.BrandRepository;
import com.xavier.mozretail.service.BrandService;
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
    private BrandService brandService;

    @Autowired
    private ApplicationEventPublisher publisher;


    @GetMapping
    public List<Brand> all() {
     return brandRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Brand> create(@Valid @RequestBody final Brand brand, HttpServletResponse response) {
        Brand savedBrand = brandService.save(brand);

        publisher.publishEvent(new ResourceCreatedEvent(this, response, savedBrand.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedBrand);

    }


    @PutMapping("/{id}")
    public Brand update(@PathVariable Long id, @Valid @RequestBody Brand brand) {
        brand.setId(id);
        return brandService.save(brand);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        brandService.deleta(id);
    }
}
