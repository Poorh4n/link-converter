package com.trendyol.linkconverter.service;

import com.trendyol.linkconverter.annotations.Persist;
import com.trendyol.linkconverter.converter.base.LinkConverterFactory;
import com.trendyol.linkconverter.data.repository.LinkConversionRepo;
import com.trendyol.linkconverter.mapper.LinkMapper;
import com.trendyol.linkconverter.model.request.DeepLinkConversionRequest;
import com.trendyol.linkconverter.model.request.WebLinkConversionRequest;
import com.trendyol.linkconverter.model.response.LinkConversionResponse;
import com.trendyol.linkconverter.util.UriUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkConversionService extends BaseService{

    private final LinkConversionRepo linkConversionRepo;
    private final LinkMapper linkMapper;

    @Persist
    public LinkConversionResponse getDeepLink (WebLinkConversionRequest req)  {
        LinkConverterFactory factory = new LinkConverterFactory();
        String convertedLink = factory.getWebConverter(UriUtils.getPageType(req)).convertLink(req.getLink());
        return new LinkConversionResponse(convertedLink);
    }

    @Persist
    public LinkConversionResponse getWebLink (DeepLinkConversionRequest req)  {
        LinkConverterFactory factory = new LinkConverterFactory();
        String convertedLink = factory.getMobileConverter(UriUtils.getPageType(req)).convertLink(req.getLink());
        return new LinkConversionResponse(convertedLink);
    }

}
