package com.example.Library.service.impl;

import com.example.Library.dao.BookRepository;
import com.example.Library.dto.BookDto;
import com.example.Library.dto.response.BookResponse;
import com.example.Library.entity.Author;
import com.example.Library.entity.Book;
import com.example.Library.entity.PublishingHouse;
import com.example.Library.exception.ResourceNotFoundException;
import com.example.Library.mapper.BookMapper;
import com.example.Library.service.AuthorService;
import com.example.Library.service.BookService;
import com.example.Library.service.PublishingHouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service

public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorService authorService;
    private final PublishingHouseService publishingHouseService;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper, AuthorService authorService, PublishingHouseService publishingHouseService) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.authorService = authorService;
        this.publishingHouseService = publishingHouseService;
    }


    @Override
    public List<BookResponse> findAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::toBookDto).toList();
    }
    @Override
    public BookResponse findBookById(Long id) {
        Book newBook = findById(id);
        return bookMapper.toBookDto(newBook);
    }
    @Override
    public void saveBook(BookDto bookDto) {
        var book = bookMapper.toBookEntity(bookDto);
        addRelations(book, bookDto);
        bookRepository.save(book);
    }
    @Override
    public void deleteBook(Long id) {
        Book newBook = findById(id);
        bookRepository.delete(newBook);
    }

    @Override
    public BookResponse updateBook(Long id, BookDto bookDto) {
        Book newBook = findById(id);

        newBook.setPublishDate(bookDto.getPublishDate());
        newBook.setTitle(bookDto.getTitle());
        newBook.setDescription(bookDto.getDescription());
        newBook.setPrice(bookDto.getPrice());
        addRelations(newBook, bookDto);
        bookRepository.save(newBook);
        return bookMapper.toBookDto(newBook);
    }

    private Book findById(Long id){
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No book data found with this id."));

    }

    public void addRelations(Book book, BookDto bookDto) {
        Set<Long> authorsIds = bookDto.getAuthors();
        Long publishingHouseId = bookDto.getPublishingHouse();
        if (authorsIds != null && !authorsIds.isEmpty()) {
            Set<Author> authors = authorsIds.stream().map(authorService::getAuthorIfExist).collect(Collectors.toSet());
            book.setAuthors(authors);
        }
        if (publishingHouseId != null) {
            PublishingHouse publishingHouse = publishingHouseService.getAuthorIfExist(publishingHouseId);
            book.setPublishingHouse(publishingHouse);
        }
    }
}
