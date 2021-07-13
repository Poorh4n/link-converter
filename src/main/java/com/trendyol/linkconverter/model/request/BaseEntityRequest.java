package com.trendyol.linkconverter.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntityRequest {

    private ZonedDateTime createdDate = ZonedDateTime.now();
    private ZonedDateTime lastModifiedDate = ZonedDateTime.now();
    private String createdBy;
    private String lastModifiedBy;
}
