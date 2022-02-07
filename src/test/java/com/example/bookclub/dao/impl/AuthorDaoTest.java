package com.example.bookclub.dao.impl;

import com.example.bookclub.dao.AuthorDao;
import com.example.bookclub.domain.Author;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.context.annotation.Import;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@JdbcTest
@Import(AuthorDaoImpl.class)
@DisplayName("В тестах AuthorDao")
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
//автоматически после каждого теста происходит откат транзакции, Propagation.NOT_SUPPORTED - отключает откат
class AuthorDaoTest {

    @Autowired
    private AuthorDao dao;

    @Test
    @DisplayName("добавляется новый автор")
    public void insert() {
        dao.insert(new Author(3, "Пушкин"));
        List<Author> all = dao.getAll();
        assertThat(all.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("автор находится по id")
    public void getById() {
        Author author = dao.getById(1);
        assertThat(author.getName()).isEqualTo("Л. Н. Толстой");
    }

    @Test
    @DisplayName("находится список авторов")
    public void getAll() {
        List<Author> all = dao.getAll();
        all.forEach(e -> System.out.println(e.getName()));
        assertThat(all.size()).isEqualTo(2);
    }
}