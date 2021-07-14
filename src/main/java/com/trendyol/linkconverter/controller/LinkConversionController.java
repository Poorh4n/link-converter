package com.trendyol.linkconverter.controller;

import com.trendyol.linkconverter.configuration.SwaggerConfiguration;
import com.trendyol.linkconverter.configuration.SwaggerDescription;
import com.trendyol.linkconverter.model.request.DeepLinkConversionRequest;
import com.trendyol.linkconverter.model.request.LinkConversionRequest;
import com.trendyol.linkconverter.model.response.LinkResponse;
import com.trendyol.linkconverter.model.request.WebLinkConversionRequest;
import com.trendyol.linkconverter.model.response.LinkConversionResponse;
import com.trendyol.linkconverter.service.LinkConversionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/link")
@RequiredArgsConstructor
@Tag(name = "Link Converter", description = SwaggerDescription.LINK_CONVERTER_V0)
public class LinkConversionController {

    private final LinkConversionService linkConversionService;

    @PostMapping("/convert-to-deep-link")
    @Operation(summary = "Get Deep Link of a web link", description = SwaggerDescription.DEEP_LINK_CONVERTER, tags = { SwaggerDescription.LINK_CONVERTER_V0 })
    public ResponseEntity<LinkConversionResponse> getDeepLink(@RequestBody @Valid @Parameter(description = SwaggerDescription.WEB_LINK , example = "https://www.trendyol.com") WebLinkConversionRequest req) {
        return ResponseEntity.ok(linkConversionService.getDeepLink(req));

    }

    @PostMapping("/convert-to-web-link")
    @Operation(summary = "Get Web Link of a deep link", description = SwaggerDescription.WEB_LINK_CONVERTER, tags = { SwaggerDescription.LINK_CONVERTER_V0 })
    public ResponseEntity<LinkConversionResponse> getWebLink(@RequestBody @Valid @Parameter(description = SwaggerDescription.DEEP_LINK , example = "ty://?Page=Home") DeepLinkConversionRequest req) {
        return ResponseEntity.ok(linkConversionService.getWebLink(req));
    }

}
