package com.trendyol.linkconverter.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeepLinkConversionRequest {

    @Pattern(regexp = "^(ty)://.*$" ,message = "Not a deep link")
    private String link;

}
