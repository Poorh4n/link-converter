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
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;


public class LinkConversionServiceTest {

    private static LinkConversionRepo linkConversionRepo = Mockito.mock(LinkConversionRepo.class);
    private static LinkConversion linkConversion;
    private static LinkConversionService service;
    private static final LinkMapper linkMapper = Mappers.getMapper(LinkMapper.class);

    @BeforeAll
    public static void init() {
       linkConversion = new LinkConversion();
       linkConversion.setCreatedBy("Test User");
       service = new LinkConversionService(linkConversionRepo, linkMapper);
    }

    @Test
    @DisplayName("Get Web Link")
    public void getWebLink() {

        DeepLinkConversionRequest request = new DeepLinkConversionRequest();
        request.setLink("ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064");
        Assertions.assertEquals("https://www.trendyol.com/brand/name-p-1925865?boutiqueId=439892&merchantId=105064",service.getWebLink(request).getConvertedLink());

        request.setLink("ty://?Page=Search&Query=elbise");
        Assertions.assertEquals("https://www.trendyol.com/sr?q=elbise",service.getWebLink(request).getConvertedLink());

        request.setLink("ty://?Page=Favorites");
        Assertions.assertEquals("https://www.trendyol.com",service.getWebLink(request).getConvertedLink());

    }

    @Test
    @DisplayName("Get Deep Link")
    public void getDeepLink() {

        WebLinkConversionRequest request = new WebLinkConversionRequest();
        request.setLink("https://www.trendyol.com/casio/saat-p-1925865?boutiqueId=439892&merchantId=105064");
        Assertions.assertEquals("ty://?Page=Product&ContentId=1925865&CampaignId=439892&MerchantId=105064",service.getDeepLink(request).getConvertedLink());

        request.setLink("https://www.trendyol.com/sr?q=elbise");
        Assertions.assertEquals("ty://?Page=Search&Query=elbise",service.getDeepLink(request).getConvertedLink());

        request.setLink("https://www.trendyol.com/Hesabim/Favoriler");
        Assertions.assertEquals("ty://?Page=Home",service.getDeepLink(request).getConvertedLink());

    }

}
