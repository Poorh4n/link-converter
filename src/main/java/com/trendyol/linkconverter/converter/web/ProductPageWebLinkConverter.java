package com.trendyol.linkconverter.converter.web;

import com.trendyol.linkconverter.constants.UrlConstants;
import com.trendyol.linkconverter.converter.base.BaseLinkConverter;
import com.trendyol.linkconverter.util.UriUtils;
import org.springframework.web.util.UriComponentsBuilder;

public class ProductPageWebLinkConverter extends BaseLinkConverter {

    @Override
    public String convertLink(String link) {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();

        String contentIdPart = UriUtils.getPathSegments(link).stream().filter(l -> l.contains("-p-")).findFirst().get();
        String contentId = contentIdPart.substring(contentIdPart.lastIndexOf("-") + 1);
        builder.queryParam(UrlConstants.PAGE, UrlConstants.PRODUCT);
        builder.queryParam(UrlConstants.CONTENT_ID, contentId);
        UriUtils.getQueryParams(link).forEach((k,v) -> {
            if(k.equals(UrlConstants.BOUTIQUE_ID)) {
                builder.queryParam(UrlConstants.CAMPAIGN_ID, v);
            }
            if(k.equals(UrlConstants.WEB_MERCHANT_ID)) {
                builder.queryParam(UrlConstants.MERCHANT_ID, v);
            }
        });
        return builder.scheme(UrlConstants.MOBILE_SCHEMA).host("").build().toUriString();

    }
}
