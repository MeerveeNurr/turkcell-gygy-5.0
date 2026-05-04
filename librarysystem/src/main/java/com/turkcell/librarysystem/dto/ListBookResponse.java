package com.turkcell.librarysystem.dto;

import java.util.UUID;

public class ListBookResponse {
private UUID id;
private String bookName;
 private String author;
 public UUID getId() {
    return id;
 }
 public void setId(UUID id) {
    this.id = id;
 }
 public String getBookName() {
    return bookName;
 }
 public void setBookName(String bookName) {
    this.bookName = bookName;
 }
 public String getAuthor() {
    return author;
 }
 public void setAuthor(String author) {
    this.author = author;
 }
 
}
