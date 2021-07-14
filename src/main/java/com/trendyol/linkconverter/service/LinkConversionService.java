package com.trendyol.linkconverter.service;

import com.trendyol.linkconverter.converter.LinkConverterFactory;
import com.trendyol.linkconverter.data.repository.LinkConversionRepo;
import com.trendyol.linkconverter.mapper.LinkMapper;
import com.trendyol.linkconverter.model.request.DeepLinkConversionRequest;
import com.trendyol.linkconverter.model.request.LinkConversionRequest;
import com.trendyol.linkconverter.model.response.LinkResponse;
import com.trendyol.linkconverter.model.request.WebLinkConversionRequest;
import com.trendyol.linkconverter.model.response.LinkConversionResponse;
import com.trendyol.linkconverter.util.UriUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkConversionService extends BaseService{

    private final LinkConversionRepo linkConversionRepo;
    private final LinkMapper linkMapper;

    public LinkConversionResponse getDeepLink (WebLinkConversionRequest req)  {
        LinkConverterFactory factory = new LinkConverterFactory();
        String convertedLink = factory.getConverter(UriUtils.getPageType(req)).convertLink(req.getLink(), false);
        linkConversionRepo.save(linkMapper.toEntity(new LinkConversionRequest(req.getLink(),convertedLink)));
        return new LinkConversionResponse(convertedLink);
    }

    public LinkConversionResponse getWebLink (DeepLinkConversionRequest req)  {
        LinkConverterFactory factory = new LinkConverterFactory();
        String convertedLink = factory.getConverter(UriUtils.getPageType(req)).convertLink(req.getLink(), true);
        linkConversionRepo.save(linkMapper.toEntity(new LinkConversionRequest(req.getLink(),convertedLink)));
        return new LinkConversionResponse(convertedLink);
    }

}
