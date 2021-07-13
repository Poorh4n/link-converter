package com.trendyol.linkconverter.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
public class LinkRequest extends BaseEntityRequest {

    @Pattern(regexp = "^(ty)://.*$" ,message = "Not a deep link")
    private String deepLink;

    @URL(protocol = "https", host = "www.trendyol.com", message = "Not valid web link")
    private String webLink;

}
