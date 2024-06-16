package com.example.Library.service.impl;

import com.example.Library.dao.AuthorRepository;
import com.example.Library.dao.BookRepository;
import com.example.Library.dao.PublishingHouseRepository;
import com.example.Library.dto.BookDto;
import com.example.Library.entity.Author;
import com.example.Library.entity.Book;
import com.example.Library.entity.PublishingHouse;
import com.example.Library.exception.ResourceNotFoundException;
import com.example.Library.mapper.AuthorMapper;
import com.example.Library.mapper.BookMapper;
import com.example.Library.mapper.PublishingHouseMapper;
import com.example.Library.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;
    private final PublishingHouseRepository publishingHouseRepository;
    private final PublishingHouseMapper publishingHouseMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper, AuthorRepository authorRepository, AuthorMapper authorMapper, PublishingHouseRepository publishingHouseRepository, PublishingHouseMapper publishingHouseMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
        this.publishingHouseRepository = publishingHouseRepository;
        this.publishingHouseMapper = publishingHouseMapper;

    }


    @Override
    public List<BookDto> findAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::toBookDto).toList();
    }
    @Override
    public BookDto findBookById(Long id) {
        Book newBook = findById(id);
        return bookMapper.toBookDto(newBook);
    }
    @Override
    public void saveBook(BookDto bookDto) {
        Author author = createAuthorIfNotExist(bookDto);
        PublishingHouse publishingHouse = createPublishingHouseIfNotExist(bookDto);
        createBook(author,publishingHouse,bookDto);
    }
    @Override
    public void deleteBook(Long id) {
        Book newBook = findById(id);
        bookRepository.delete(newBook);
    }

    @Override
    public BookDto updateBook(Long id, BookDto bookDto) {
        Book newBook = findById(id);

        newBook.setAuthor(authorMapper.toAuthorEntity(bookDto.author()));
        newBook.setPublishingHouse(publishingHouseMapper.toPublishingHouseEntity((bookDto.publishingHouse())));
        newBook.setPublishDate(bookDto.publishDate());
        newBook.setTitle(bookDto.title());
        bookRepository.save(newBook);
        return bookMapper.toBookDto(newBook);
    }

    private Author createAuthorIfNotExist( BookDto bookDto){
        Author author = authorRepository.findAuthorByFullName(bookDto.author().fullName());

        if(!authorIsExist(author)) {
            author = new Author();
            author.setFullName(bookDto.author().fullName());
            author.setBirthdayDate(bookDto.author().birthdayDate());
            authorRepository.save(author);
            return author;
        }else{
            return author;
        }
    }
    private boolean authorIsExist(Author author){
        if(author == null){
            return false;
        }else {
            return true;
        }
    }

    private PublishingHouse createPublishingHouseIfNotExist( BookDto bookDto){
        PublishingHouse publishingHouse = publishingHouseRepository.findPublishingHouseByName(bookDto.publishingHouse().name());

        if(!publishingHouseIsExist(publishingHouse)){
            publishingHouse = new PublishingHouse();
            publishingHouse.setName(bookDto.publishingHouse().name());
            publishingHouseRepository.save(publishingHouse);
            return publishingHouse;
        }else{
            return publishingHouse;
        }
    }

    private boolean publishingHouseIsExist(PublishingHouse publishingHouse){
        if(publishingHouse == null){
            return false;
        }else {
            return true;
        }
    }
    private void createBook(Author author, PublishingHouse publishingHouse, BookDto bookDto){
        Book book = bookMapper.toBookEntity(bookDto);
        book.setAuthor(author);
        book.setPublishingHouse(publishingHouse);
        bookRepository.save(book);
    }

    private Book findById(Long id){
        Book newBook = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No author data found with this id."));
        return newBook;
    }
}
