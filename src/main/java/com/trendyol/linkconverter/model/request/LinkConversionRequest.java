package com.trendyol.linkconverter.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LinkConversionRequest extends BaseEntityRequest {

    private String source;
    private String target;

}
