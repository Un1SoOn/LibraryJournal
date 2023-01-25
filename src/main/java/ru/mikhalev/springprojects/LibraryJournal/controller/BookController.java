package ru.mikhalev.springprojects.LibraryJournal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mikhalev.springprojects.LibraryJournal.controller.api.BookApi;
import ru.mikhalev.springprojects.LibraryJournal.service.functional.api.BookService;

/**
 * @author Ivan Mikhalev
 */

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController implements BookApi {
    private final BookService bookService;
    @Override
    public String getAllBooks() {
        return null;
    }

    @Override
    public String newBook() {
        return null;
    }

    @Override
    public String editBook(int id) {
        return null;
    }

    @Override
    public String addBook() {
        return null;
    }

    @Override
    public String updateBook(int id) {
        return null;
    }

    @Override
    public String deleteBook(int id) {
        return null;
    }
}
