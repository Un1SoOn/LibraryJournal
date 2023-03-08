package ru.mikhalev.springprojects.LibraryJournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mikhalev.springprojects.LibraryJournal.model.Book;

import java.util.List;

/**
 * @author Ivan Mikhalev
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findBooksByPersonId(int id);
}
