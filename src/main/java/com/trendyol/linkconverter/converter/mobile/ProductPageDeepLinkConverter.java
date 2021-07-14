package com.trendyol.linkconverter.converter.mobile;

import com.trendyol.linkconverter.constants.UrlConstants;
import com.trendyol.linkconverter.converter.base.BaseLinkConverter;
import com.trendyol.linkconverter.util.UriUtils;
import org.springframework.web.util.UriComponentsBuilder;

public class ProductPageDeepLinkConverter extends BaseLinkConverter {

    @Override
    public String convertLink(String link) {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();

        UriUtils.getQueryParams(link).forEach((k,v) -> {
            if(k.equals(UrlConstants.CONTENT_ID)) {
                builder.path("brand/name-p-" + v);
            }
            if(k.equals(UrlConstants.CAMPAIGN_ID)) {
                builder.queryParam(UrlConstants.BOUTIQUE_ID, v);
            }
            if(k.equals(UrlConstants.MERCHANT_ID)) {
                builder.queryParam(UrlConstants.WEB_MERCHANT_ID, v);
            }
        });
        return builder.scheme(UrlConstants.WEB_SCHEMA).host(UrlConstants.HOST).build().toUriString();

    }
}
