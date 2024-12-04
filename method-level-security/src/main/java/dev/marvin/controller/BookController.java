package dev.marvin.controller;

import dev.marvin.domain.Employee;
import dev.marvin.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/details/{name}")
    public Employee getDetails(@PathVariable("name") String name){
        return bookService.getBookDetails(name);
    }
}
