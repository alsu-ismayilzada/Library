package com.example.Library.service;

import com.example.Library.dto.BookDto;
import com.example.Library.dto.PublishingHouseDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PublishingHouseService {

    List<PublishingHouseDto> findAllPublishingHouses();
    PublishingHouseDto findPublishingHouseById(Long id);
    void savePublishingHouse(PublishingHouseDto publishingHouseDto);
    void deletePublishingHouse(Long id);
    PublishingHouseDto updatePublishingHouse(Long id, PublishingHouseDto publishingHouseDto);
}
