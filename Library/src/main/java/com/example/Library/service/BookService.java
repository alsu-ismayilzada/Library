package com.example.Library.service;

import com.example.Library.dto.AuthorDto;
import com.example.Library.dto.BookDto;
import com.example.Library.dto.response.BookResponse;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    List<BookResponse> findAllBooks();
    BookResponse findBookById(Long id);
    void saveBook(BookDto bookDto);
    void deleteBook(Long id);
    BookResponse updateBook(Long id, BookDto bookDto);
}
