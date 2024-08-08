package com.example.Library.mapper;

import com.example.Library.dto.AuthorDto;
import com.example.Library.entity.Author;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AuthorMapper {

    Author toAuthorEntity(AuthorDto authorDto);
    AuthorDto toAuthorDto(Author author);


}
