package com.example.Library.mapper;

import com.example.Library.dto.PublishingHouseDto;
import com.example.Library.entity.PublishingHouse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PublishingHouseMapper {

    PublishingHouse toPublishingHouseEntity(PublishingHouseDto publishingHouseDto);
    PublishingHouseDto toPublishingHouseDto(PublishingHouse publishingHouse);
}
