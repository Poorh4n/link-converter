package com.trendyol.linkconverter.data.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.time.ZonedDateTime;

@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@EntityListeners({ AuditingEntityListener.class })
public abstract class AbstractEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @CreatedDate
    @Column(name = "created_date", nullable = false, updatable = false)
    @JsonIgnore
    @Getter @Setter
    private ZonedDateTime createdDate = ZonedDateTime.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    @JsonIgnore
    @Getter @Setter
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();

    @CreatedBy
    @Column(name = "created_by", updatable = false)
    @JsonIgnore
    @Getter @Setter
    private String createdBy;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    @JsonIgnore
    @Getter @Setter
    private String lastModifiedBy;

}

