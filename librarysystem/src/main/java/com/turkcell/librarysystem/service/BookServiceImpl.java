package com.turkcell.librarysystem.service;
import java.util.ArrayList;

import java.util.List;
import org.springframework.stereotype.Service;

import com.turkcell.librarysystem.dto.CreateBookRequest;
import com.turkcell.librarysystem.dto.CreatedBookResponse;
import com.turkcell.librarysystem.dto.ListBookResponse;
import com.turkcell.librarysystem.entity.Books;
import com.turkcell.librarysystem.repository.BooksRepository;

import jakarta.persistence.EntityManager;

@Service
public class BookServiceImpl {
    private final BooksRepository booksRepository;
    private final EntityManager entityManager;

    public BookServiceImpl(BooksRepository booksRepository,EntityManager entityManager) {
        this.booksRepository = booksRepository;
        this.entityManager=entityManager;
    }
    public CreatedBookResponse create (CreateBookRequest createBookRequest){
        Books book= new Books();
        book.setBookName(createBookRequest.getBookName());
        book.setAuthor(createBookRequest.getAuthor());
        book.setNumberOfPages(createBookRequest.getNumberOfPages());

        book= this.booksRepository.save(book);

        CreatedBookResponse response = new CreatedBookResponse();
        response.setId(book.getId());
        response.setBookName(book.getBookName());
        response.setAuthor(book.getAuthor());
        response.setNumberOfPages(book.getNumberOfPages());

        return response;
    }

    public List<ListBookResponse> getAll(){
        List<Books> books = this.booksRepository.findAll();
        List<ListBookResponse> responseList = new ArrayList<>();
        for(Books book:books){
            ListBookResponse response = new ListBookResponse();
            response.setId(book.getId());
            response.setBookName(book.getBookName());
            response.setAuthor(book.getAuthor());
            
           responseList.add(response);
        }
        return responseList;
        
    }

}
