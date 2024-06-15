package com.example.Library.mapper;

import com.example.Library.dto.BookDto;
import com.example.Library.entity.Author;
import com.example.Library.entity.Book;
import com.example.Library.entity.PublishingHouse;
import java.time.LocalDate;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-14T23:36:43+0400",
    comments = "version: 1.5.0.Final, compiler: javac, environment: Java 17.0.9 (JetBrains s.r.o.)"
)
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto toBookDto(Book book) {
        if ( book == null ) {
            return null;
        }

        String title = null;
        LocalDate publishDate = null;
        Author author = null;
        PublishingHouse publishingHouse = null;

        title = book.getTitle();
        publishDate = book.getPublishDate();
        author = book.getAuthor();
        publishingHouse = book.getPublishingHouse();

        BookDto bookDto = new BookDto( title, publishDate, author, publishingHouse );

        return bookDto;
    }

    @Override
    public Book toBookEntity(BookDto bookDto) {
        if ( bookDto == null ) {
            return null;
        }

        Book book = new Book();

        book.setTitle( bookDto.title() );
        book.setPublishDate( bookDto.publishDate() );
        book.setAuthor( bookDto.author() );
        book.setPublishingHouse( bookDto.publishingHouse() );

        return book;
    }
}
