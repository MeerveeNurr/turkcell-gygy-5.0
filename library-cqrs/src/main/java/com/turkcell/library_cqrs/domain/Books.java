package com.turkcell.library_cqrs.domain;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Books {

    @Id
    @UuidGenerator
    @Column(name="id")
    private UUID id;

    @Column(name="book_name",nullable=false,length=100)
    private String bookName;
    @Column(name="author_name",nullable=false,length=100)
    private String author;
    @Column(name="numberOfPages")
    private int numberOfPages;
    @Column(name = "is_Available", columnDefinition = "boolean default true")
    private boolean isAvailable;

    public Books() {}

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getBookName() { return bookName; }
    public void setBookName(String bookName) { this.bookName = bookName; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getNumberOfPages() { return numberOfPages; }
    public void setNumberOfPages(int numberOfPages) { this.numberOfPages = numberOfPages; }

    public boolean isAvailable() { return isAvailable; }
    public void setAvailable(boolean available) { isAvailable = available; }
}