package com.example.Library.service;

import com.example.Library.dto.AuthorDto;
import com.example.Library.dto.BookDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    List<BookDto> findAllBooks();
    BookDto findBookById(Long id);
    void saveBook(BookDto bookDto);
    void deleteBook(Long id);
    BookDto updateBook(Long id, BookDto bookDto);
}
