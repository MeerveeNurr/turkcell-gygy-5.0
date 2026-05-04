package com.turkcell.librarysystem.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turkcell.librarysystem.dto.CreateBookRequest;
import com.turkcell.librarysystem.dto.CreatedBookResponse;
import com.turkcell.librarysystem.dto.ListBookResponse;
import com.turkcell.librarysystem.service.BookServiceImpl;

@RestController
@RequestMapping("/api/books")
public class BooksController {
    private final BookServiceImpl bookServiceImpl;

    public BooksController(BookServiceImpl bookServiceImpl) {
        this.bookServiceImpl = bookServiceImpl;
    }
    @PostMapping()
    public CreatedBookResponse create(@RequestBody CreateBookRequest createBookRequest){
        return bookServiceImpl.create(createBookRequest);

    }
     @GetMapping()
    public List<ListBookResponse> getAll(){
        return bookServiceImpl.getAll();
    } 
}
