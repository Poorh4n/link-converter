package com.trendyol.linkconverter.converter;

import com.trendyol.linkconverter.constants.UrlConstants;

public class HomeLinkConverter extends BaseLinkConverter{

    @Override
    public String convertLink(String link, boolean deepLink) {
        return deepLink ? UrlConstants.WEBLINK_HOME_PAGE : UrlConstants.DEEPLINK_HOME_PAGE;
    }
}
