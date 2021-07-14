package com.trendyol.linkconverter.mapper;

import com.trendyol.linkconverter.data.entity.LinkConversion;
import com.trendyol.linkconverter.model.request.LinkConversionRequest;
import com.trendyol.linkconverter.model.response.LinkResponse;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-07-14T14:13:21+0300",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 14.0.1 (Oracle Corporation)"
)
@Component
public class LinkMapperImpl implements LinkMapper {

    @Override
    public LinkResponse toResource(LinkConversion paramEntity) {
        if ( paramEntity == null ) {
            return null;
        }

        LinkResponse linkResponse = new LinkResponse();

        return linkResponse;
    }

    @Override
    public LinkConversion toEntity(LinkConversionRequest req) {
        if ( req == null ) {
            return null;
        }

        LinkConversion linkConversion = new LinkConversion();

        linkConversion.setCreatedDate( req.getCreatedDate() );
        linkConversion.setLastModifiedDate( req.getLastModifiedDate() );
        linkConversion.setCreatedBy( req.getCreatedBy() );
        linkConversion.setLastModifiedBy( req.getLastModifiedBy() );
        linkConversion.setSource( req.getSource() );
        linkConversion.setTarget( req.getTarget() );

        return linkConversion;
    }
}
