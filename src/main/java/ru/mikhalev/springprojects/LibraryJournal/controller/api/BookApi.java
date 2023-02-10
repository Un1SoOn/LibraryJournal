package ru.mikhalev.springprojects.LibraryJournal.controller.api;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mikhalev.springprojects.LibraryJournal.model.Book;
import ru.mikhalev.springprojects.LibraryJournal.model.Person;

@RequestMapping("/books")
public interface BookApi {
    @GetMapping()
    String getAllBooks(Model model);

    @GetMapping("/new")
    String newBook(Model model);

    @GetMapping("/{id}")
    String showBook(@PathVariable int id, Model model);

    @GetMapping("/{id}/edit")
    String editBook(@PathVariable("id") int id, Model model);

    @PostMapping("/{id}/edit")
    String editBook(@PathVariable("id") int id, Book updatedBook);

    @DeleteMapping("/{id}")
    String deleteBook(@PathVariable("id") int id);

    @PostMapping()
    String newBook(@ModelAttribute("person") Book book);
}
