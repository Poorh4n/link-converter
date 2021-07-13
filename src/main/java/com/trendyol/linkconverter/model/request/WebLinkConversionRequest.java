package com.trendyol.linkconverter.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebLinkConversionRequest {

    @URL(protocol = "https", host = "www.trendyol.com", message = "Not valid web link")
    private String link;
}
