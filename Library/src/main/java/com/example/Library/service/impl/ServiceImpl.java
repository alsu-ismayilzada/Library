package com.example.Library.service.impl;

import com.example.Library.dao.AuthorRepository;
import com.example.Library.dto.AuthorDto;
import com.example.Library.entity.Author;
import com.example.Library.exception.ResourceNotFoundException;
import com.example.Library.mapper.AuthorMapper;
import com.example.Library.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public ServiceImpl(AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public List<AuthorDto> findAllAuthors() {
        return  authorRepository.findAll().stream().map(authorMapper::toAuthorDto).toList();
    }

    @Override
    public AuthorDto findAuthorById(Long id) {
        Author newAuthor = findById(id);
        return authorMapper.toAuthorDto(newAuthor);
    }

    @Override
    public void saveAuthor(AuthorDto authorDto) {
        authorRepository.save(authorMapper.toAuthorEntity(authorDto));
    }

    @Override
    public void deleteAuthor(Long id) {
        Author newAuthor = findById(id);
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto updateAuthor(Long id, AuthorDto authorDto) {
        Author newAuthor = findById(id);
        newAuthor.setFullName(authorDto.fullName());
        newAuthor.setBirthdayDate(authorDto.birthdayDate());
        authorRepository.save(newAuthor);
        return authorMapper.toAuthorDto(newAuthor);
    }

    private Author findById(Long id){
        Author newAuthor = authorRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No author data found with this id."));
        return newAuthor;
    }
}
