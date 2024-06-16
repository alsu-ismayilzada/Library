package com.example.Library.controller;

import com.example.Library.dto.PublishingHouseDto;
import com.example.Library.service.PublishingHouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/publishing-houses")
public class PublishingHouseController {

    private final PublishingHouseService publishingHouseService;

    public PublishingHouseController(PublishingHouseService publishingHouseService) {
        this.publishingHouseService = publishingHouseService;
    }

    @GetMapping
    List<PublishingHouseDto> getAllPublishingHouses(){
        return publishingHouseService.findAllPublishingHouses();
    }
    @GetMapping("{id}")
    PublishingHouseDto getPublishingHouseById(@PathVariable Long id){
        return publishingHouseService.findPublishingHouseById(id);
    }
    @DeleteMapping("{id}")
    void deletePublishingHouse(@PathVariable Long id){
        publishingHouseService.deletePublishingHouse(id);
    }
    @PostMapping
    void savePublishingHouse(@RequestBody PublishingHouseDto publishingHouseDto){
        publishingHouseService.savePublishingHouse(publishingHouseDto);
    }

    @PutMapping("/update/{id}")
    PublishingHouseDto updatePublishingHouseDto(@PathVariable Long id, @RequestBody PublishingHouseDto publishingHouseDto){
        return publishingHouseService.updatePublishingHouse(id,publishingHouseDto);
    }
}
