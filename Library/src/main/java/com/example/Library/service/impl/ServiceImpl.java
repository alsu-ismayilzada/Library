package com.example.Library.service.impl;

import com.example.Library.dao.AuthorRepository;
import com.example.Library.dto.AuthorDto;
import com.example.Library.entity.Author;
import com.example.Library.mapper.AuthorMapper;
import com.example.Library.service.AuthorService;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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
        Author newAuthor = getAuthorIfExist(id);
        return authorMapper.toAuthorDto(newAuthor);
    }

    @Override
    public void saveAuthor(AuthorDto authorDto) {
        authorRepository.save(authorMapper.toAuthorEntity(authorDto));
    }

    @Override
    public void deleteAuthor(Long id) {
        Author newAuthor = getAuthorIfExist(id);
        authorRepository.deleteById(id);
    }

    @Override
    public AuthorDto updateAuthor(Long id, AuthorDto authorDto) {
        Author newAuthor = getAuthorIfExist(id);
        newAuthor.setFullName(authorDto.getFullName());
        newAuthor.setBirthdayDate(authorDto.getBirthdayDate());
        newAuthor.setEmail(authorDto.getEmail());
        authorRepository.save(newAuthor);
        return authorMapper.toAuthorDto(newAuthor);
    }


    public Author getAuthorIfExist(Long id){
        return authorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(NOT_FOUND, String.format(
                "Author with id [%d] was not found!", id
        )));
    }
}
