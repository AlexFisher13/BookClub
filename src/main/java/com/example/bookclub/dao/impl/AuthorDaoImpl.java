package com.example.bookclub.dao.impl;

import com.example.bookclub.dao.AuthorDao;
import com.example.bookclub.domain.Author;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@AllArgsConstructor
public class AuthorDaoImpl implements AuthorDao {

    private final JdbcOperations jdbc;

    @Override
    public void insert(Author author) {
        jdbc.update("insert into author (id, `name`) values (?, ?)", author.getId(), author.getName());
    }

    @Override
    public Author getById(long id) {
        return jdbc.queryForObject("select * from author where id = ?", new Object[] {id}, new AuthorMapper());
    }

    @Override
    public List<Author> getAll() {
        return jdbc.query("select * from author", new AuthorMapper());
    }

    private static class AuthorMapper implements RowMapper<Author> {
        @Override
        public Author mapRow(ResultSet resultSet, int i) throws SQLException {
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            return new Author(id, name);
        }
    }
}
