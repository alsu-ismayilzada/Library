package com.example.Library.mapper;

import com.example.Library.dto.AuthorDto;
import com.example.Library.entity.Author;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T23:36:43+0400",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public Author toAuthorEntity(AuthorDto authorDto) {
        if ( authorDto == null ) {
            return null;
        }

        Author author = new Author();

        author.setName( authorDto.name() );

        return author;
    }

    @Override
    public AuthorDto toAuthorDto(Author author) {
        if ( author == null ) {
            return null;
        }

        String name = null;

        name = author.getName();

        AuthorDto authorDto = new AuthorDto( name );

        return authorDto;
    }
}
