package com.trendyol.linkconverter.converter.web;

import com.trendyol.linkconverter.constants.UrlConstants;
import com.trendyol.linkconverter.converter.base.BaseLinkConverter;

public class HomePageWebLinkConverter extends BaseLinkConverter {

    @Override
    public String convertLink(String link) {
        return  UrlConstants.DEEPLINK_HOME_PAGE;
    }
}
