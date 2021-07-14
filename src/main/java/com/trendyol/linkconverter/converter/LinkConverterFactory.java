package com.trendyol.linkconverter.converter;

import com.trendyol.linkconverter.enums.PageType;

public class LinkConverterFactory extends BaseLinkFactory {

    @Override
    public BaseLinkConverter getConverter(PageType pageType) {
        BaseLinkConverter baseLinkConverter;
        switch (pageType) {
            case PRODUCT_PAGE -> baseLinkConverter = new ProductPageLinkConverter();
            case SEARCH_PAGE -> baseLinkConverter = new SearchPageLinkConverter();
            default -> baseLinkConverter = new HomeLinkConverter();
        }
        return baseLinkConverter;
    }
}
