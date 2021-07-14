package com.trendyol.linkconverter.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.trendyol.linkconverter.model.request.DeepLinkConversionRequest;
import com.trendyol.linkconverter.model.request.WebLinkConversionRequest;
import com.trendyol.linkconverter.model.response.LinkConversionResponse;
import com.trendyol.linkconverter.service.LinkConversionService;
import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.doReturn;
import static org.hamcrest.Matchers.*;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class LinkConversionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private LinkConversionService service;


    @Test
    public void shouldReturnDeepLink() throws Exception {
        LinkConversionResponse response = new LinkConversionResponse();
        response.setConvertedLink("ty://?Page=Product&ContentId=1925865");
        WebLinkConversionRequest request = new WebLinkConversionRequest();
        request.setLink("https://www.trendyol.com/casio/erkek-kol-saati-p-1925865");
        doReturn(response).when(service).getDeepLink(request);
        mockMvc.perform(post("/api/link/convert-to-deep-link").
                content(asJsonString(request)).
                contentType(MediaType.APPLICATION_JSON))
                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the returned fields
                .andExpect(jsonPath("$.convertedLink", is("ty://?Page=Product&ContentId=1925865")));

    }

    @Test
    public void shouldReturnWebLink() throws Exception {
        LinkConversionResponse response = new LinkConversionResponse();
        response.setConvertedLink("https://www.trendyol.com/brand/name-p-1925865");
        DeepLinkConversionRequest request = new DeepLinkConversionRequest();
        request.setLink("ty://?Page=Product&ContentId=1925865");
        doReturn(response).when(service).getWebLink(request);
        mockMvc.perform(post("/api/link/convert-to-web-link").
                content(asJsonString(request)).
                contentType(MediaType.APPLICATION_JSON))
                // Validate the response code and content type
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))

                // Validate the returned fields
                .andExpect(jsonPath("$.convertedLink", is("https://www.trendyol.com/brand/name-p-1925865")));

    }

    @Test
    public void shouldReturn400() throws Exception {
        LinkConversionResponse response = new LinkConversionResponse();
        response.setConvertedLink("https://www.trendyol.com/brand/name-p-1925865");
        DeepLinkConversionRequest request = new DeepLinkConversionRequest();
        request.setLink("t://?Page=Product&ContentId=1925865");
        doReturn(response).when(service).getWebLink(request);
        mockMvc.perform(post("/api/link/convert-to-web-link").
                content(asJsonString(request)).
                contentType(MediaType.APPLICATION_JSON))
                // Validate the response code and content type
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));


    }

    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
