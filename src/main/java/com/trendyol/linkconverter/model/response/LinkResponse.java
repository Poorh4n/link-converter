package com.trendyol.linkconverter.model.response;

import com.trendyol.linkconverter.model.response.DefaultResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkResponse extends DefaultResponse {

    private String deepLink;
    private String webLink;
}
