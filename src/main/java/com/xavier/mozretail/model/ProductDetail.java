package com.xavier.mozretail.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Entity
@Table(name = "product_detail")
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProductDetail {

    @Id
   // @SequenceGenerator(name = "product_detail_seq", sequenceName = "product_detail_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "product_detail_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "image_id")
    private Image image;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "size_id")
    private Size size;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
