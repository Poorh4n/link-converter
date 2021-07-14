package com.trendyol.linkconverter.converter.base;

import com.trendyol.linkconverter.converter.base.BaseLinkConverter;
import com.trendyol.linkconverter.enums.PageType;

public abstract class BaseLinkFactory {

    public abstract BaseLinkConverter getMobileConverter(PageType pageType);
    public abstract BaseLinkConverter getWebConverter(PageType pageType);
}
