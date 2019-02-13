package com.xavier.mozretail.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "color")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Color {

    @Id
   // @SequenceGenerator(name = "color_seq", sequenceName = "color_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "color_id")
    private Long id;

    @Column(name = "color_name")
    private String colorName;

    @Column(name = "color_hexadesignation")
    private String colorHexadesignation;


}
