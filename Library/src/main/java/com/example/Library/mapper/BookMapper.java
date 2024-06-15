package com.example.Library.mapper;

import com.example.Library.dto.BookDto;
import com.example.Library.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookMapper {

    BookDto toBookDto(Book book);
    Book toBookEntity(BookDto bookDto);

}
