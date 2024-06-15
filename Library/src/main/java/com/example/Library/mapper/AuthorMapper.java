package com.example.Library.mapper;

import com.example.Library.dao.BookRepository;
import com.example.Library.dto.AuthorDto;
import com.example.Library.entity.Author;
import com.example.Library.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toAuthorEntity(AuthorDto authorDto);
    AuthorDto toAuthorDto(Author author);


}
