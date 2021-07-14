package com.trendyol.linkconverter.converter;

import com.trendyol.linkconverter.enums.PageType;

public abstract class BaseLinkFactory {

    public abstract BaseLinkConverter getConverter(PageType pageType);
}
