package com.xavier.mozretail.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "brand")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "brand_id")
    private Long id;

    @Column(name = "brand_name")
    @NotBlank(message = "brand-1")
    private String brandName;

    @JsonIgnore
    public Boolean isNew() {
        return this.getId() == null;
    }

    @JsonIgnore
    public Boolean BrandExists() {
        return this.getId() != null;
    }


}
