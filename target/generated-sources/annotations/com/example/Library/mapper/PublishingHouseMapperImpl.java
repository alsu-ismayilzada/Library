package com.example.Library.mapper;

import com.example.Library.dto.PublishingHouseDto;
import com.example.Library.entity.PublishingHouse;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T23:36:43+0400",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class PublishingHouseMapperImpl implements PublishingHouseMapper {

    @Override
    public PublishingHouse toPublishingHouseEntity(PublishingHouseDto publishingHouseDto) {
        if ( publishingHouseDto == null ) {
            return null;
        }

        PublishingHouse publishingHouse = new PublishingHouse();

        publishingHouse.setName( publishingHouseDto.name() );

        return publishingHouse;
    }

    @Override
    public PublishingHouseDto toPublishingHouseDto(PublishingHouse publishingHouse) {
        if ( publishingHouse == null ) {
            return null;
        }

        String name = null;

        name = publishingHouse.getName();

        PublishingHouseDto publishingHouseDto = new PublishingHouseDto( name );

        return publishingHouseDto;
    }
}
