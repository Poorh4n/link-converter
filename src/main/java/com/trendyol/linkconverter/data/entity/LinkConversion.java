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

    @Column(name = "WEB_LINK", nullable = false, unique = true)
    @Getter @Setter
    private String webLink;

    @Column(name = "DEEP_LINK", nullable = false, unique = true)
    @Getter @Setter
    private String deepLink;

}
