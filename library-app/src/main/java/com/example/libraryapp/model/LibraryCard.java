package com.example.libraryapp.model;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LibraryCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String LibararyCardCode;
    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public LibraryCard() {
    }

    public LibraryCard(Long id, String libararyCardCode, Book book) {
        this.id = id;
        LibararyCardCode = libararyCardCode;
        this.book = book;
    }

    public LibraryCard(Long id, String libararyCardCode) {
        this.id = id;
        LibararyCardCode = libararyCardCode;
    }

    public LibraryCard(Long id) {
        this.id = id;
    }

    public LibraryCard(String libararyCardCode) {
        LibararyCardCode = libararyCardCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibararyCardCode() {
        return LibararyCardCode;
    }

    public void setLibararyCardCode(String libararyCardCode) {
        LibararyCardCode = libararyCardCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
