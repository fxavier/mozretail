package com.xavier.mozretail.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "size")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Size {

    @Id
   // @SequenceGenerator(name = "size_seq", sequenceName = "size_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "size_id")
    private Long sizeId;

    @Column(name = "size_designation")
    private String sizeDesignation;
}
