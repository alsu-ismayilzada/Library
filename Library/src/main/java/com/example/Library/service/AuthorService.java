package com.example.Library.service;

import com.example.Library.dto.AuthorDto;

import java.util.List;


public interface AuthorService {

    List<AuthorDto> findAllAuthors();
    AuthorDto findAuthorById(Long id);
    void saveAuthor(AuthorDto authorDto);
    void deleteAuthor(Long id);
    AuthorDto updateAuthor(Long id, AuthorDto authorDto);
}
