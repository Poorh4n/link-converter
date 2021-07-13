package com.trendyol.linkconverter.controller;

import com.trendyol.linkconverter.model.request.DeepLinkConversionRequest;
import com.trendyol.linkconverter.model.request.LinkRequest;
import com.trendyol.linkconverter.model.response.LinkResponse;
import com.trendyol.linkconverter.model.request.WebLinkConversionRequest;
import com.trendyol.linkconverter.model.response.LinkConversionResponse;
import com.trendyol.linkconverter.service.LinkConversionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/link")
@RequiredArgsConstructor
public class LinkConversionController {

    private final LinkConversionService linkConversionService;

    @PostMapping("/convert-to-deep-link")
    public ResponseEntity<LinkConversionResponse> getDeepLink(@RequestBody @Valid WebLinkConversionRequest req) {
        return ResponseEntity.ok(linkConversionService.getDeepLink(req));

    }

    @PostMapping("/convert-to-web-link")
    public ResponseEntity<LinkConversionResponse> getWebLink(@RequestBody @Valid DeepLinkConversionRequest req) {
        return ResponseEntity.ok(linkConversionService.getWebLink(req));
    }

    @PutMapping
    public ResponseEntity<LinkResponse> save(@RequestBody @Valid LinkRequest req) {
        return ResponseEntity.ok(linkConversionService.save(req));
    }

}
