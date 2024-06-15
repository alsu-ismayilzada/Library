package com.example.Library.controller;

import com.example.Library.dto.BookDto;
import com.example.Library.service.BookService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    List<BookDto> getAllBooks(){
        return bookService.findAllBooks();
    }
    @GetMapping("/{id}")
    BookDto getBookById(@PathVariable Long id){
        return bookService.findBookById(id);
    }
    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id){
        bookService.deleteBook(id);
    }
    @PostMapping
    void saveBook(@RequestBody BookDto bookDto){
        bookService.saveBook(bookDto);
    }
}
