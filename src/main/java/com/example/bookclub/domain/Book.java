package com.example.bookclub.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Book {
    private long id;
    private String name;
    private long authorId;
    private long genreId;
}
