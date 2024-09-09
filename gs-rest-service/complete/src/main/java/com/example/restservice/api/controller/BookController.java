package com.example.restservice.api.controller;

import com.example.restservice.api.model.Book;
import com.example.restservice.api.model.BookInfo;
import com.example.restservice.service.BookService;

import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class BookController {
    private BookService bookService;
    private int nextId = 11;
    
    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public Object getBook(@RequestParam Optional<Integer> id){
        if(id.isPresent()){
            Optional<Book> book = bookService.getBook((int) id.get());
            if(book.isPresent()){
                return new ResponseEntity<Book>((Book) book.get(), HttpStatus.OK);
            }
            return new ResponseEntity<String>("Sorry, the requested book does not exist", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Book>>(bookService.getBookList(), HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<Book> createBook(@RequestBody BookInfo iBook) {
        Book oBook = new Book(iBook.author, iBook.title, iBook.synopsis, iBook.release_date, nextId);
        nextId++;
        bookService.getBookList().add(oBook);
        return new ResponseEntity<Book>(oBook, HttpStatus.CREATED);
    }

    @PutMapping("/books")
    public Object editBook(@RequestBody BookInfo iBook, @RequestParam int id) {
        Optional<Book> book = bookService.getBook(id);
        if(book.isPresent()){
            Book oBook = (Book) book.get();
            oBook.setAuthor(iBook.author);
            oBook.setTitle(iBook.title);
            oBook.setSynopsis(iBook.synopsis);
            oBook.setReleaseDate(iBook.release_date);
            return new ResponseEntity<Book>(oBook, HttpStatus.OK);
        }
        return new ResponseEntity<String>("Sorry, the requested book does not exist", HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/books")
    public Object deleteBook(@RequestParam int id){
        Optional<Book> book = bookService.getBook(id);
        if(book.isPresent()){
            Book oBook = (Book) book.get();
            bookService.getBookList().remove(oBook);
            return new ResponseEntity<Book>(oBook, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<String>("Sorry, the requested book does not exist", HttpStatus.NOT_FOUND);
    }
}
