package com.trendyol.linkconverter.data.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "LINK_CONVERSIONS")
public class LinkConversion extends AbstractEntity {

    @Id
    @SequenceGenerator(name = "link_conversion_id_gen", sequenceName = "link_conversion_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "link_conversion_id_gen", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "SOURCE", nullable = false, unique = true)
    @Getter @Setter
    private String source;

    @Column(name = "TARGET", nullable = false, unique = true)
    @Getter @Setter
    private String target;

}
