package com.example.Library.service;

import com.example.Library.dto.BookDto;
import com.example.Library.dto.PublishingHouseDto;
import com.example.Library.entity.PublishingHouse;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PublishingHouseService {

    List<PublishingHouseDto> findAllPublishingHouses();
    PublishingHouseDto findPublishingHouseById(Long id);
    void savePublishingHouse(PublishingHouseDto publishingHouseDto);
    void deletePublishingHouse(Long id);
    PublishingHouseDto updatePublishingHouse(Long id, PublishingHouseDto publishingHouseDto);
    PublishingHouse getAuthorIfExist(Long id);
}
