package com.example.Library.mapper;

import com.example.Library.dto.BookDto;
import com.example.Library.dto.response.BookResponse;
import com.example.Library.entity.Author;
import com.example.Library.entity.Book;
import com.example.Library.entity.PublishingHouse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface BookMapper {

        @Mapping(target = "authors", source = "authors", qualifiedByName = "getAuthorsList")
        @Mapping(target = "publishingHouse", source = "publishingHouse", qualifiedByName = "getPublishingHouse")
        BookResponse toBookDto(Book book);

        @Mapping(target = "authors", ignore = true)
        @Mapping(target = "publishingHouse", ignore = true)
        Book toBookEntity(BookDto bookDto);

        @Named("getAuthorsList")
        default Set<String> getAuthorsList(Set<Author> authors) {
                return authors.stream()
                        .map(Author::getFullName)
                        .collect(Collectors.toSet());
        }

        @Named("getPublishingHouse")
        default String getPublishingHouse(PublishingHouse publishingHouse) {
                return publishingHouse.getName();
        }


}
