package ru.mikhalev.springprojects.LibraryJournal.service.functional.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.mikhalev.springprojects.LibraryJournal.model.Book;
import ru.mikhalev.springprojects.LibraryJournal.repository.BookRepository;

import java.util.List;

/**
 * @author Ivan Mikhalev
 */

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void editBook(int id, Book updatedBook) {
        Book book = Book.getBookByOptional(bookRepository.findById(id));
        book.setTitle(updatedBook.getTitle());
        book.setAuthorFullName(updatedBook.getAuthorFullName());
        book.setPublicationYear(updatedBook.getPublicationYear());
        bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public List<Book> showAllBooks() {
        return bookRepository.findAll();
    }

    public Book showOneBook(int id) {
        return bookRepository.getReferenceById(id);
    }

    public void editBookOwner(int id, @ModelAttribute Book updatedBook) {
        Book book = Book.getBookByOptional(bookRepository.findById(id));
        book.setPersonId(updatedBook.getPersonId());
        bookRepository.save(book);
    }

    public void departureBook(int id) {
        Book book = bookRepository.getReferenceById(id);
        book.setPersonId(null);
        bookRepository.save(book);
    }
}
