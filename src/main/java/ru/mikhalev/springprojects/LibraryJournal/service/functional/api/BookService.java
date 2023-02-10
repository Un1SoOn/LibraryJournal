package ru.mikhalev.springprojects.LibraryJournal.service.functional.api;

import ru.mikhalev.springprojects.LibraryJournal.model.Book;

import java.util.List;

/**
 * @author Ivan Mikhalev
 */
public interface BookService {
    void addBook(Book book);
    void editBook(int id, Book updatedBook);
    void deleteBook(int id);
    List<Book> showAllBooks();
    Book showOneBook(int id);
}
