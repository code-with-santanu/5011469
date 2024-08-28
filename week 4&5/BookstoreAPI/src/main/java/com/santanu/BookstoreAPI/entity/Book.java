package com.santanu.BookstoreAPI.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    private int id;

    private String title;
    private String author;
    private float price;
    private long isbn;

}
