package ru.mikhalev.springprojects.LibraryJournal.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mikhalev.springprojects.LibraryJournal.controller.api.BookApi;

@RestController
@RequestMapping("/books")
public class BookController implements BookApi {
}
