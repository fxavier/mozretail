package com.xavier.mozretail.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "category")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "category_id")
    private Long id;

    @NotBlank(message = "category-1")
    private String name;

    @JsonIgnore
    public Boolean isNew() {
        return this.id == null;
    }

    @JsonIgnore
    public  Boolean categoryExists() {
        return !isNew();
    }
}
