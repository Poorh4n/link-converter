package com.trendyol.linkconverter.converter.mobile;

import com.trendyol.linkconverter.constants.UrlConstants;
import com.trendyol.linkconverter.converter.base.BaseLinkConverter;

public class HomePageDeepLinkConverter extends BaseLinkConverter {

    @Override
    public String convertLink(String link) {
        return UrlConstants.WEBLINK_HOME_PAGE;
    }
}
