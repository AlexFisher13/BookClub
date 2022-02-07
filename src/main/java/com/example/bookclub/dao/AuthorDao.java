package com.example.bookclub.dao;

import com.example.bookclub.domain.Author;

import java.util.List;

public interface AuthorDao {
    void insert(Author author);
    Author getById(long id);
    List<Author> getAll();
}
