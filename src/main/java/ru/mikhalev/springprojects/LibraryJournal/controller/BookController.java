package ru.mikhalev.springprojects.LibraryJournal.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mikhalev.springprojects.LibraryJournal.controller.api.BookApi;
import ru.mikhalev.springprojects.LibraryJournal.model.Book;
import ru.mikhalev.springprojects.LibraryJournal.service.functional.impl.BookService;
import ru.mikhalev.springprojects.LibraryJournal.service.functional.impl.PersonService;

/**
 * @author Ivan Mikhalev
 */

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController implements BookApi {
    private final BookService bookService;
    private final PersonService personService;

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
        model.addAttribute("people", personService.showAllPersons());
        model.addAttribute("personId", bookService.showOneBook(id).getPersonId());
        Integer personId = bookService.showOneBook(id).getPersonId();

        if(personId != null)
            model.addAttribute("person", personService.showOnePerson(personId));

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
    public String editBook(@PathVariable int id, @Valid Book updatedBook, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "books/editBookPage";
        bookService.editBook(id, updatedBook);
        return "redirect:/books";
    }

    @Override
    @PostMapping("/{id}/appoint")
    public String editBookOwner(@PathVariable int id, Book updatedBook) {
        bookService.editBookOwner(id, updatedBook);
        return "redirect:/books/{id}";
    }

    @Override
    public String departureBook(@PathVariable int id) {
        bookService.departureBook(id);
        return "redirect:/books/{id}";
    }

    @Override
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @Override
    @PostMapping("/new")
    public String newBook(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "books/newBookPage";

        book.setPersonId(null);
        bookService.addBook(book);
        return "redirect:/books";
    }
}
