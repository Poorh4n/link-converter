package com.trendyol.linkconverter.util;

import com.trendyol.linkconverter.constants.UrlConstants;
import com.trendyol.linkconverter.enums.PageType;
import com.trendyol.linkconverter.model.request.DeepLinkConversionRequest;
import com.trendyol.linkconverter.model.request.WebLinkConversionRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

public class UriUtils {

    public static List<String> getPathSegments(String link) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(link).build();
        return uriComponents.getPathSegments();
    }

    public static Map<String, String> getQueryParams(String link) {
        UriComponents uriComponents = UriComponentsBuilder.fromUriString(link).build();
        return uriComponents.getQueryParams().toSingleValueMap();
    }

    public static PageType getPageType(WebLinkConversionRequest request) {
        List<String> paths = getPathSegments(request.getLink());
        return paths.stream().anyMatch(path -> path.equals(UrlConstants.WEB_SEARCH_PATH)) ? PageType.SEARCH_PAGE :
                (paths.stream().anyMatch(path -> path.contains("-p-")) ? PageType.PRODUCT_PAGE : PageType.HOME_PAGE);
    }

    public static PageType getPageType(DeepLinkConversionRequest request) {
        String page = getQueryParams(request.getLink()).get(UrlConstants.PAGE);
        switch (page) {
            case UrlConstants.PRODUCT: return PageType.PRODUCT_PAGE;
            case UrlConstants.SEARCH: return PageType.SEARCH_PAGE;
            default: return PageType.HOME_PAGE;
        }

    }
}
