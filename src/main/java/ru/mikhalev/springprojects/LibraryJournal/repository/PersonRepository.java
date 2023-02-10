package ru.mikhalev.springprojects.LibraryJournal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mikhalev.springprojects.LibraryJournal.model.Person;

/**
 * @author Ivan Mikhalev
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
