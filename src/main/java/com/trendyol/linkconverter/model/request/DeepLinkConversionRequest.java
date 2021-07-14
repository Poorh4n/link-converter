package com.trendyol.linkconverter.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeepLinkConversionRequest extends LinkRequest{

    @Pattern(regexp = "^(ty)://.*$" ,message = "Not a deep link")
    private String link;

}
