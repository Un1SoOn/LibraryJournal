package ru.mikhalev.springprojects.LibraryJournal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mikhalev.springprojects.LibraryJournal.controller.api.BookApi;
import ru.mikhalev.springprojects.LibraryJournal.model.Book;
import ru.mikhalev.springprojects.LibraryJournal.model.Person;
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
    @GetMapping()
    public String getAllBooks(Model model) {
        model.addAttribute("books", bookService.showAllBooks());
        return "books/allBooks";
    }

    @Override
    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "books/newBookPage";
    }

    @Override
    public String showBook(int id, Model model) {
        model.addAttribute("book", bookService.showOneBook(id));
        return "books/showBookPage";
    }

    @Override
    @GetMapping("/{id}/edit")
    public String editBook(@PathVariable int id, Model model) {
        model.addAttribute("book", bookService.showOneBook(id));
        return "books/editBookPage";
    }

    @Override
    @PostMapping("/{id}/edit")
    public String editBook(@PathVariable int id, Book updatedBook) {
        bookService.editBook(id, updatedBook);
        return "redirect:/books";
    }

    @Override
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @Override
    @PostMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        bookService.addBook(book);
        return "redirect:/books";
    }
}
