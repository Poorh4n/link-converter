package com.trendyol.linkconverter.service;

import com.trendyol.linkconverter.data.entity.LinkConversion;
import com.trendyol.linkconverter.data.repository.LinkConversionRepo;
import com.trendyol.linkconverter.exceptions.LinkNotFoundException;
import com.trendyol.linkconverter.mapper.LinkMapper;
import com.trendyol.linkconverter.model.request.DeepLinkConversionRequest;
import com.trendyol.linkconverter.model.request.LinkRequest;
import com.trendyol.linkconverter.model.response.LinkResponse;
import com.trendyol.linkconverter.model.request.WebLinkConversionRequest;
import com.trendyol.linkconverter.model.response.LinkConversionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LinkConversionService extends BaseService{

    private final LinkConversionRepo linkConversionRepo;
    private final LinkMapper linkMapper;

    public LinkConversionResponse getDeepLink (WebLinkConversionRequest req) throws LinkNotFoundException {
        LinkConversion linkConversion = linkConversionRepo.findByWebLink(req.getLink()).orElseThrow(LinkNotFoundException::new);
        return new LinkConversionResponse(linkConversion.getDeepLink());
    }

    public LinkConversionResponse getWebLink (DeepLinkConversionRequest req) throws LinkNotFoundException {
        LinkConversion linkConversion = linkConversionRepo.findByDeepLink(req.getLink()).orElseThrow(LinkNotFoundException::new);
        return new LinkConversionResponse(linkConversion.getWebLink());
    }

    public LinkResponse save(LinkRequest req) {
        LinkResponse response = linkMapper.toResource(linkConversionRepo.save(linkMapper.toEntity(req)));
        response.setStatus(HttpStatus.OK);
        return response;
    }

}
