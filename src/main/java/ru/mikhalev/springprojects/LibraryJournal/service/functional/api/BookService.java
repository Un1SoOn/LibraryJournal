package ru.mikhalev.springprojects.LibraryJournal.service.functional.api;

/**
 * @author Ivan Mikhalev
 */
public interface BookService {
    String addBook();
    String changeBook();
    String deleteBook();
    String showAllBooks();
}
