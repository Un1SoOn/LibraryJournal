package ru.mikhalev.springprojects.LibraryJournal.service.functional.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mikhalev.springprojects.LibraryJournal.model.Book;
import ru.mikhalev.springprojects.LibraryJournal.model.Person;
import ru.mikhalev.springprojects.LibraryJournal.repository.BookRepository;
import ru.mikhalev.springprojects.LibraryJournal.service.functional.api.BookService;

import java.util.List;

/**
 * @author Ivan Mikhalev
 */

@Service
@RequiredArgsConstructor
public class BookImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void editBook(int id, Book updatedBook) {
        Book book = Book.getBookByOptional(bookRepository.findById(id));
        book.setTitle(updatedBook.getTitle());
        book.setAuthorFullName(updatedBook.getAuthorFullName());
        book.setPublicationYear(updatedBook.getPublicationYear());
        bookRepository.save(book);
    }

    @Override
    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    @Override
    public List<Book> showAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book showOneBook(int id) {
        return bookRepository.getReferenceById(id);
    }
}
