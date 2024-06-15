package com.example.Library.service.impl;

import com.example.Library.dao.AuthorRepository;
import com.example.Library.dao.BookRepository;
import com.example.Library.dao.PublishingHouseRepository;
import com.example.Library.dto.BookDto;
import com.example.Library.entity.Author;
import com.example.Library.entity.Book;
import com.example.Library.entity.PublishingHouse;
import com.example.Library.mapper.AuthorMapper;
import com.example.Library.mapper.BookMapper;
import com.example.Library.mapper.PublishingHouseMapper;
import com.example.Library.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;
    private final AuthorRepository authorRepository;
    private final PublishingHouseRepository publishingHouseRepository;

    @Override
    public List<BookDto> findAllBooks() {
        return bookRepository.findAll().stream().map(bookMapper::toBookDto).toList();
    }
    @Override
    public BookDto findBookById(Long id) {
        return bookRepository.findById(id).stream().map(bookMapper::toBookDto).findFirst().get();
    }
    @Override
    public void saveBook(BookDto bookDto) {
        Author author = createAuthorIfNotExist(bookDto);
        PublishingHouse publishingHouse = createPublishingHouseIfNotExist(bookDto);
        createBook(author,publishingHouse,bookDto);
    }
    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    private Author createAuthorIfNotExist( BookDto bookDto){
        Author author = authorRepository.findAuthorByName(bookDto.author().name());

        if(!authorIsExist(author)) {
            author = new Author();
            author.setName(bookDto.author().name());
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
}
