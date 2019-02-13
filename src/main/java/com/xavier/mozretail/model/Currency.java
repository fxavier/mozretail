package com.xavier.mozretail.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "currency")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Currency {

    @Id
 //   @SequenceGenerator(name = "currency_seq", sequenceName = "currency_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "currency_id")
    private Long id;

    private String currencyName;

    private String currencyCode;
}
