package com.example.Library.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Table(name = "books")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title;
    LocalDate publishDate;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "author_id", referencedColumnName = "id")
    Author author;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "publishing_house_id", referencedColumnName = "id")
    PublishingHouse publishingHouse;

    public Book() {
    }

    public Book(String title, LocalDate publishDate, Author author, PublishingHouse publishingHouse) {
        this.title = title;
        this.publishDate = publishDate;
        this.author = author;
        this.publishingHouse = publishingHouse;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public Author getAuthor() {
        return author;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
}
