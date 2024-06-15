package com.example.Library.controller;

import com.example.Library.dto.AuthorDto;
import com.example.Library.service.AuthorService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    @GetMapping
    List<AuthorDto> getAllAuthor(){
       return authorService.findAllAuthors();
    }

    @GetMapping("/{id}")
    AuthorDto getAuthorById(@PathVariable Long id){
        return authorService.findAuthorById(id);
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id){
        authorService.deleteAuthor(id);
    }

    @PostMapping
    void saveAuthor(@RequestBody AuthorDto authorDto){
        authorService.saveAuthor(authorDto);
    }

}
