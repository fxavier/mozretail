package com.xavier.mozretail.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "subcategory")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Subcategory {

    @Id
   // @SequenceGenerator(name = "subcategory_seq", sequenceName = "subcategory_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "subcategory_id")
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
