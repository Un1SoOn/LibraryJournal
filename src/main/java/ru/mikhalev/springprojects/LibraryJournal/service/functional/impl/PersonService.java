package ru.mikhalev.springprojects.LibraryJournal.service.functional.impl;

import lombok.RequiredArgsConstructor;
import org.hibernate.TypeMismatchException;
import org.springframework.stereotype.Service;
import ru.mikhalev.springprojects.LibraryJournal.model.Book;
import ru.mikhalev.springprojects.LibraryJournal.model.Person;
import ru.mikhalev.springprojects.LibraryJournal.repository.BookRepository;
import ru.mikhalev.springprojects.LibraryJournal.repository.PersonRepository;

import java.util.List;

/**
 * @author Ivan Mikhalev
 */

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;
    private final BookRepository bookRepository;

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void editPerson(int id, Person updatedPerson) {
        Person person = Person.getPersonByOptional(personRepository.findById(id));
        person.setFullName(updatedPerson.getFullName());
        person.setBirthYear(updatedPerson.getBirthYear());
        personRepository.save(person);
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public List<Person> showAllPersons() {
        return personRepository.findAll();
    }

    public Person showOnePerson(int id) {
        return personRepository.getReferenceById(id);
    }

    public List<Book> getBooksByPersonId(int id){
        return bookRepository.findBooksByPersonId(id);
    }
}
