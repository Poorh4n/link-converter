package com.trendyol.linkconverter.mapper;

import com.trendyol.linkconverter.data.entity.AbstractEntity;
import com.trendyol.linkconverter.model.request.BaseEntityRequest;
import com.trendyol.linkconverter.model.response.DefaultResponse;

public interface BaseMapper<Entity extends AbstractEntity, Req extends BaseEntityRequest, Resource extends DefaultResponse> {
    Resource toResource(Entity paramEntity);

    Entity toEntity(Req req);

}
