package com.example.Library.service.impl;

import com.example.Library.dao.PublishingHouseRepository;
import com.example.Library.dto.PublishingHouseDto;
import com.example.Library.mapper.PublishingHouseMapper;
import com.example.Library.service.PublishingHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PublishingHouseServiceImpl implements PublishingHouseService {

    private final PublishingHouseMapper publishingHouseMapper;
    private final PublishingHouseRepository publishingHouseRepository;

    public List<PublishingHouseDto> findAllPublishingHouses() {
        return publishingHouseRepository.findAll().stream().map(publishingHouseMapper::toPublishingHouseDto).toList();
    }

    @Override
    public PublishingHouseDto findPublishingHouseById(Long id) {
        return publishingHouseRepository.findById(id).stream().map(publishingHouseMapper::toPublishingHouseDto).findFirst().get();
    }

    @Override
    public void savePublishingHouse(PublishingHouseDto publishingHouseDto) {
        publishingHouseRepository.save(publishingHouseMapper.toPublishingHouseEntity(publishingHouseDto));
    }

    @Override
    public void deletePublishingHouse(Long id) {
        publishingHouseRepository.deleteById(id);
    }

}
