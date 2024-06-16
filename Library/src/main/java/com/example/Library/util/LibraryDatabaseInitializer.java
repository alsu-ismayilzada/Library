package com.example.Library.util;

import com.example.Library.dao.AuthorRepository;
import com.example.Library.dao.BookRepository;
import com.example.Library.dao.PublishingHouseRepository;
import com.example.Library.entity.Author;
import com.example.Library.entity.Book;
import com.example.Library.entity.PublishingHouse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class LibraryDatabaseInitializer implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final PublishingHouseRepository publishingHouseRepository;
    private final BookRepository bookRepository;

    public LibraryDatabaseInitializer(AuthorRepository authorRepository, PublishingHouseRepository publishingHouseRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.publishingHouseRepository = publishingHouseRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) {

        seedAuthors();

        seedPublishingHouses();

        seedBooks();
    }

    private void seedAuthors() {
        Author author1 = new Author("J. R. R. Tolkien", LocalDate.of(1892, 1, 3));
        Author author2 = new Author("Harper Lee", LocalDate.of(1926, 4, 28));
        Author author3 = new Author("Mary Shelley", LocalDate.of(1797, 8, 31));
        Author author4 = new Author("F. Scott Fitzgerald", LocalDate.of(1896, 9, 24));
        Author author5 = new Author("Gabriel García Márquez", LocalDate.of(1927, 3, 6));
        Author author6 = new Author("William Shakespeare", LocalDate.of(1564, 4, 23));
        Author author7 = new Author("Homer", null);
        Author author8 = new Author("Miguel de Cervantes", LocalDate.of(1547, 9, 29));
        Author author9 = new Author("Marcel Proust", LocalDate.of(1871, 7, 10));
        Author author10 = new Author("Arthur Conan Doyle", LocalDate.of(1859, 5, 22));

        authorRepository.saveAll(List.of(author1, author2, author3, author4, author5, author6, author7, author8, author9, author10));
    }

    private void seedPublishingHouses() {

        PublishingHouse publishingHouse1 = new PublishingHouse("Houghton Mifflin Harcourt");
        PublishingHouse publishingHouse2 = new PublishingHouse("HarperCollins");
        PublishingHouse publishingHouse3 = new PublishingHouse("Penguin Classics");
        PublishingHouse publishingHouse4 = new PublishingHouse("Scribner");
        PublishingHouse publishingHouse5 = new PublishingHouse("Penguin Random House");
        PublishingHouse publishingHouse6 = new PublishingHouse("Folger Shakespeare Library");
        PublishingHouse publishingHouse7 = new PublishingHouse("W. W. Norton & Company");
        PublishingHouse publishingHouse8 = new PublishingHouse("Various");

        publishingHouseRepository.saveAll(List.of(publishingHouse1, publishingHouse2, publishingHouse3, publishingHouse4, publishingHouse5, publishingHouse6, publishingHouse7, publishingHouse8));
    }

    private void seedBooks() {
        List<Author> authors = authorRepository.findAll();
        List<PublishingHouse> publishingHouses = publishingHouseRepository.findAll();

        Book book1 = new Book("The Lord of the Rings", LocalDate.of(1954, 1, 1), authors.get(0), publishingHouses.get(0));
        Book book2 = new Book("To Kill a Mockingbird", LocalDate.of(1960, 1, 1), authors.get(1), publishingHouses.get(1));
        Book book3 = new Book("Frankenstein", LocalDate.of(1818, 1, 1), authors.get(2), publishingHouses.get(2));
        Book book4 = new Book("The Great Gatsby", LocalDate.of(1925, 1, 1), authors.get(3), publishingHouses.get(4));
        Book book5 = new Book("One Hundred Years of Solitude", LocalDate.of(1967, 1, 1), authors.get(5), publishingHouses.get(5));
        Book book6 = new Book("Hamlet", LocalDate.of(1603, 1, 1), authors.get(6), publishingHouses.get(6));
        Book book7 = new Book("The Odyssey", LocalDate.of(800, 1, 1), authors.get(7), publishingHouses.get(7));
        Book book8 = new Book("Don Quixote", LocalDate.of(1605, 1, 1), authors.get(8), publishingHouses.get(6));
        Book book9 = new Book("In Search of Lost Time", LocalDate.of(1913, 1, 1), authors.get(9), publishingHouses.get(6));
        Book book10 = new Book("The Adventures of Sherlock Holmes", LocalDate.of(1891, 1, 1), authors.get(8), publishingHouses.get(3));

        bookRepository.saveAll(List.of(book1, book2, book3, book4, book5, book6, book7, book8, book9, book10));
    }
}
