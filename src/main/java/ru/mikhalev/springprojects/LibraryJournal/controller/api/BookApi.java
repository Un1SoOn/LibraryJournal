package ru.mikhalev.springprojects.LibraryJournal.controller.api;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/books")
public interface BookApi {
    @GetMapping
    String getAllBooks();

    @GetMapping("/new")
    String newBook();

    @GetMapping("/{id}/edit")
    String editBook(@PathVariable("id") int id);

    @PostMapping
    String addBook();

    @PatchMapping("{id}")
    String updateBook(@PathVariable("id") int id);

    @DeleteMapping("{id}")
    String deleteBook(@PathVariable("id") int id);
}
