package com.trendyol.linkconverter.service;

import com.trendyol.linkconverter.data.entity.LinkConversion;
import com.trendyol.linkconverter.data.repository.LinkConversionRepo;
import com.trendyol.linkconverter.mapper.LinkMapper;
import com.trendyol.linkconverter.model.request.DeepLinkConversionRequest;
import com.trendyol.linkconverter.model.request.WebLinkConversionRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.hateoas.Link;

import java.util.Optional;
import java.util.UUID;

public class LinkConversionServiceTest {

    private static final String webLink = "https://www.trendyol.com/test";
    private static final String deepLink = "ty://test";
    private static LinkConversionRepo linkConversionRepo = Mockito.mock(LinkConversionRepo.class);
    private static LinkConversion linkConversion;
    private static UUID rand;
    private static LinkConversionService service;
    private static final LinkMapper linkMapper = Mappers.getMapper(LinkMapper.class);

    @BeforeAll
    public static void init() {
       rand =  UUID.randomUUID();
       linkConversion = new LinkConversion();
       linkConversion.setDeepLink(deepLink);
       linkConversion.setWebLink(webLink);
       linkConversion.setCreatedBy("Test User");
       service = new LinkConversionService(linkConversionRepo, linkMapper);
    }

    @Test
    @DisplayName("Get Web Link")
    public void getWebLink() {

        Mockito.when(linkConversionRepo.findByDeepLink(deepLink)).thenReturn(Optional.of(linkConversion));
        DeepLinkConversionRequest req = new DeepLinkConversionRequest();
        req.setLink(deepLink);
        Assertions.assertEquals(webLink, service.getWebLink(req).getConvertedLink());


    }

    @Test
    @DisplayName("Get Deep Link")
    public void getDeepLink() {
        Mockito.when(linkConversionRepo.findByWebLink(webLink)).thenReturn(Optional.of(linkConversion));
        WebLinkConversionRequest req = new WebLinkConversionRequest();
        req.setLink(webLink);
        Assertions.assertEquals(deepLink, service.getDeepLink(req).getConvertedLink());

    }

}
