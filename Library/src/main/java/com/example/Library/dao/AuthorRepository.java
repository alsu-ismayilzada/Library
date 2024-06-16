package com.example.Library.dao;

import com.example.Library.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface AuthorRepository extends JpaRepository<Author,Long> {

    Author findAuthorByFullName(String fullName);
}
