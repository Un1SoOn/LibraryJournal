package ru.mikhalev.springprojects.LibraryJournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mikhalev.springprojects.LibraryJournal.model.Book;

/**
 * @author Ivan Mikhalev
 */

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
}
