package com.example.Library.service.impl;

import com.example.Library.dao.PublishingHouseRepository;
import com.example.Library.dto.PublishingHouseDto;
import com.example.Library.entity.PublishingHouse;
import com.example.Library.exception.ResourceNotFoundException;
import com.example.Library.mapper.PublishingHouseMapper;
import com.example.Library.service.PublishingHouseService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class PublishingHouseServiceImpl implements PublishingHouseService {

    private final PublishingHouseMapper publishingHouseMapper;
    private final PublishingHouseRepository publishingHouseRepository;

    public PublishingHouseServiceImpl(PublishingHouseMapper publishingHouseMapper, PublishingHouseRepository publishingHouseRepository) {
        this.publishingHouseMapper = publishingHouseMapper;
        this.publishingHouseRepository = publishingHouseRepository;
    }

    public List<PublishingHouseDto> findAllPublishingHouses() {
        return publishingHouseRepository.findAll().stream().map(publishingHouseMapper::toPublishingHouseDto).toList();
    }

    @Override
    public PublishingHouseDto findPublishingHouseById(Long id) {
        PublishingHouse newPublishingHouse = getAuthorIfExist(id);
        return publishingHouseMapper.toPublishingHouseDto(newPublishingHouse);
    }

    @Override
    public void savePublishingHouse(PublishingHouseDto publishingHouseDto) {
        publishingHouseRepository.save(publishingHouseMapper.toPublishingHouseEntity(publishingHouseDto));
    }

    @Override
    public void deletePublishingHouse(Long id) {
        PublishingHouse newPublishingHouse = getAuthorIfExist(id);
        publishingHouseRepository.delete(newPublishingHouse);
    }

    @Override
    public PublishingHouseDto updatePublishingHouse(Long id, PublishingHouseDto publishingHouseDto) {
        PublishingHouse newPublishingHouse = getAuthorIfExist(id);
        newPublishingHouse.setName(publishingHouseDto.getName());

        publishingHouseRepository.save(newPublishingHouse);
        return publishingHouseMapper.toPublishingHouseDto(newPublishingHouse);
    }

    @Override
    public  PublishingHouse getAuthorIfExist(Long id){
        return publishingHouseRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, String.format(
                "PublishingHouse with id [%d] was not found!", id
        )));    }

}
