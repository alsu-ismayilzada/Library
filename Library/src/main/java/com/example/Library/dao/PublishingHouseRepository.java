package com.example.Library.dao;

import com.example.Library.entity.PublishingHouse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublishingHouseRepository extends JpaRepository<PublishingHouse, Long> {

    PublishingHouse findPublishingHouseByName(String name);
}
