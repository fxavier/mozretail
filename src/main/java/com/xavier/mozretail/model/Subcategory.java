package com.xavier.mozretail.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "subcategory")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Subcategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "subcategory_id")
    private Long id;

    @NotBlank(message ="sucategory-1")
    private String name;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    @NotNull(message = "subcategory-2")
    private Category category;

    @JsonIgnore
    public Boolean isNew() {
        return this.id == null;
    }

    @JsonIgnore
    public Boolean isExists() {
        return this.id != null;
    }
}
