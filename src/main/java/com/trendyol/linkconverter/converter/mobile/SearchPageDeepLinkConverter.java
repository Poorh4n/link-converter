package com.trendyol.linkconverter.converter.mobile;

import com.trendyol.linkconverter.constants.UrlConstants;
import com.trendyol.linkconverter.converter.base.BaseLinkConverter;
import com.trendyol.linkconverter.util.UriUtils;
import org.springframework.web.util.UriComponentsBuilder;


public class SearchPageDeepLinkConverter extends BaseLinkConverter {

    @Override
    public String convertLink(String link) {
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance();

        builder.path(UrlConstants.WEB_SEARCH_PATH);
        builder.queryParam(UrlConstants.WEB_QUERY_PATH, UriUtils.getQueryParams(link).get(UrlConstants.MOBILE_QUERY_PATH));
        return builder.scheme(UrlConstants.WEB_SCHEMA).host(UrlConstants.HOST).build().toUriString();

    }
}
