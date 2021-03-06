package com.trendyol.linkconverter.mapper;

import com.trendyol.linkconverter.data.entity.LinkConversion;
import com.trendyol.linkconverter.model.request.LinkConversionRequest;
import com.trendyol.linkconverter.model.response.LinkResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LinkMapper extends BaseMapper<LinkConversion, LinkConversionRequest, LinkResponse> {
}
