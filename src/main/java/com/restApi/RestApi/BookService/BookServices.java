package com.restApi.RestApi.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restApi.RestApi.BookEntity.Book;
import com.restApi.RestApi.Repo.BookRepo;

import java.util.List;
import java.util.Optional;

@Service
public class BookServices {

    @Autowired
    private BookRepo bookRepo;

    // Get all books
    public List<Book> getAllBook() {
        return (List<Book>) bookRepo.findAll();
    }

    // Get book by ID
    public Optional<Book> getBookById(int id) {
        return Optional.ofNullable(bookRepo.findById(id));
    }

    // Add book
    public Book addBook(Book book) {
        return bookRepo.save(book);
    }

    // Delete book by ID
    public void deleteBook(int id) {
        bookRepo.deleteById(id);
    }

    // Update book
    public Book updateBook(Book book, int id) {
        if (bookRepo.existsById(id)) {
            book.setId(id);
            return bookRepo.save(book);
        } else {
            throw new RuntimeException("Book with id " + id + " does not exist");
        }
    }
}
