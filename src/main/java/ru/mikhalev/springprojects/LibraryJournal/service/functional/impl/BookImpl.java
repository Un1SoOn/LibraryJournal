package ru.mikhalev.springprojects.LibraryJournal.service.functional.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mikhalev.springprojects.LibraryJournal.repository.BookRepository;
import ru.mikhalev.springprojects.LibraryJournal.service.functional.api.BookService;

/**
 * @author Ivan Mikhalev
 */

@Service
@RequiredArgsConstructor
public class BookImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public String addBook() {
        return null;
    }

    @Override
    public String changeBook() {
        return null;
    }

    @Override
    public String deleteBook() {
        return null;
    }

    @Override
    public String showAllBooks() {
        return null;
    }
}
