package com.example.Library.dao;

import com.example.Library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {

    Author findAuthorByName(String name);
}
