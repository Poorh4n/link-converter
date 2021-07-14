package com.trendyol.linkconverter.converter;

import com.trendyol.linkconverter.constants.UrlConstants;
import com.trendyol.linkconverter.util.UriUtils;
import org.springframework.web.util.UriComponentsBuilder;


public class SearchPageLinkConverter extends BaseLinkConverter {

    @Override
    public String convertLink(String link, boolean deepLink) {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();

        if(deepLink) {
            builder.path(UrlConstants.WEB_SEARCH_PATH);
            builder.queryParam(UrlConstants.WEB_QUERY_PATH, UriUtils.getQueryParams(link).get(UrlConstants.MOBILE_QUERY_PATH));
            return builder.scheme(UrlConstants.WEB_SCHEMA).host(UrlConstants.HOST).build().toUriString();
        } else {
            builder.queryParam(UrlConstants.PAGE, UrlConstants.SEARCH);
            builder.queryParam(UrlConstants.MOBILE_QUERY_PATH, UriUtils.getQueryParams(link).get(UrlConstants.WEB_QUERY_PATH));
            return builder.scheme(UrlConstants.MOBILE_SCHEMA).host("").build().toUriString();
        }

    }
}
