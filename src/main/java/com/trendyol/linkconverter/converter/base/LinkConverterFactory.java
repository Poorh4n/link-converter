package com.trendyol.linkconverter.converter.base;

import com.trendyol.linkconverter.converter.web.HomePageWebLinkConverter;
import com.trendyol.linkconverter.converter.web.ProductPageWebLinkConverter;
import com.trendyol.linkconverter.converter.web.SearchPageWebLinkConverter;
import com.trendyol.linkconverter.converter.mobile.HomePageDeepLinkConverter;
import com.trendyol.linkconverter.converter.mobile.ProductPageDeepLinkConverter;
import com.trendyol.linkconverter.converter.mobile.SearchPageDeepLinkConverter;
import com.trendyol.linkconverter.enums.PageType;

public class LinkConverterFactory extends BaseLinkFactory {

    @Override
    public BaseLinkConverter getMobileConverter(PageType pageType) {
        BaseLinkConverter baseLinkConverter;
        switch (pageType) {
            case PRODUCT_PAGE -> baseLinkConverter = new ProductPageDeepLinkConverter();
            case SEARCH_PAGE -> baseLinkConverter = new SearchPageDeepLinkConverter();
            default -> baseLinkConverter = new HomePageDeepLinkConverter();
        }
        return baseLinkConverter;
    }

    @Override
    public BaseLinkConverter getWebConverter(PageType pageType) {
        BaseLinkConverter baseLinkConverter;
        switch (pageType) {
            case PRODUCT_PAGE -> baseLinkConverter = new ProductPageWebLinkConverter();
            case SEARCH_PAGE -> baseLinkConverter = new SearchPageWebLinkConverter();
            default -> baseLinkConverter = new HomePageWebLinkConverter();
        }
        return baseLinkConverter;
    }
}
