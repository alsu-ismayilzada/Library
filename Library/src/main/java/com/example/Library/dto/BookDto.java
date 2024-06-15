package com.example.Library.dto;

import com.example.Library.entity.Author;
import com.example.Library.entity.PublishingHouse;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
public record BookDto(
         String title,
         LocalDate publishDate,
         AuthorDto author,
         PublishingHouseDto publishingHouse
){
    public BookDto(String title, LocalDate publishDate, AuthorDto author, PublishingHouseDto publishingHouse) {
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.publishingHouse = publishingHouse;
    }
}
