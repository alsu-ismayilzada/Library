package com.example.Library.service.impl;

import com.example.Library.dao.AuthorRepository;
import com.example.Library.dto.AuthorDto;
import com.example.Library.mapper.AuthorMapper;
import com.example.Library.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ServiceImpl implements AuthorService{

    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    @Override
    public List<AuthorDto> findAllAuthors() {
        return  authorRepository.findAll().stream().map(authorMapper::toAuthorDto).toList();
    }

    @Override
    public AuthorDto findAuthorById(Long id) {
        return authorRepository.findById(id).stream().map(authorMapper::toAuthorDto).findFirst().get();
    }

    @Override
    public void saveAuthor(AuthorDto authorDto) {
        authorRepository.save(authorMapper.toAuthorEntity(authorDto));
    }

    @Override
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
