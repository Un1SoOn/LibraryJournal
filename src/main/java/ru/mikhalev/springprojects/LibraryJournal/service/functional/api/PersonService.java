package ru.mikhalev.springprojects.LibraryJournal.service.functional.api;

import ru.mikhalev.springprojects.LibraryJournal.model.Person;

import java.util.List;

/**
 * @author Ivan Mikhalev
 */
public interface PersonService {
    void addPerson(Person person);
    void editPerson(int id, Person updatedPerson);
    void deletePerson(int id);
    List<Person> showAllPersons();

    Person showOnePerson(int id);
}
