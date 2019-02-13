package com.xavier.mozretail.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "country")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Country {

    @Id
   // @SequenceGenerator(name = "country_seq", sequenceName = "country_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "country_id")
    private Long id;

    @Column(name = "country_name")
    private String countryName;

    private String code;

}
