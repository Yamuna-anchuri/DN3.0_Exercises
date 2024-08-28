package com.example.BookstoreAPI.controller;

import com.example.BookstoreAPI.model.Book;
import com.example.BookstoreAPI.exception.BookNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.BookstoreAPI.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    // GET method to retrieve all books
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // POST method to add a new book
    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        Book savedBook = bookRepository.save(book);

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "Book-Creation");

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(savedBook);
    }

    // PUT method to update a book by ID
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @Valid @RequestBody Book updatedBook) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if (optionalBook.isPresent()) {
            Book existingBook = optionalBook.get();
            existingBook.setTitle(updatedBook.getTitle());
            existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setPrice(updatedBook.getPrice());
            existingBook.setIsbn(updatedBook.getIsbn());

            Book savedBook = bookRepository.save(existingBook);

            HttpHeaders headers = new HttpHeaders();
            headers.add("X-Custom-Header", "Book-Update");

            return ResponseEntity.ok().headers(headers).body(savedBook);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // DELETE method to remove a book by ID
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBook(@PathVariable Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book with ID " + id + " not found.");
        }
        bookRepository.deleteById(id);
    }

    // GET method to retrieve a book by ID using path variable
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book with ID " + id + " not found."));

        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Custom-Header", "Book-Found");
        return ResponseEntity.ok().headers(headers).body(book);
    }
}
