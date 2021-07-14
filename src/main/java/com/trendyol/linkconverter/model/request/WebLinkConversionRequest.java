package com.trendyol.linkconverter.model.request;

import com.trendyol.linkconverter.enums.PageType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.URL;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WebLinkConversionRequest  extends LinkRequest {

    @URL(protocol = "https", host = "www.trendyol.com", message = "Not valid web link")
    private String link;
}
