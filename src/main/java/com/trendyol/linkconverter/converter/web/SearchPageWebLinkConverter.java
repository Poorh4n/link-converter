package com.trendyol.linkconverter.converter.web;

import com.trendyol.linkconverter.constants.UrlConstants;
import com.trendyol.linkconverter.converter.base.BaseLinkConverter;
import com.trendyol.linkconverter.util.UriUtils;
import org.springframework.web.util.UriComponentsBuilder;


public class SearchPageWebLinkConverter extends BaseLinkConverter {

    @Override
    public String convertLink(String link) {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();
        builder.queryParam(UrlConstants.PAGE, UrlConstants.SEARCH);
        builder.queryParam(UrlConstants.MOBILE_QUERY_PATH, UriUtils.getQueryParams(link).get(UrlConstants.WEB_QUERY_PATH));
        return builder.scheme(UrlConstants.MOBILE_SCHEMA).host("").build().toUriString();

    }
}
