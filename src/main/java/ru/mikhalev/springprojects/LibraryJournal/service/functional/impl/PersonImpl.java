package ru.mikhalev.springprojects.LibraryJournal.service.functional.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mikhalev.springprojects.LibraryJournal.model.Person;
import ru.mikhalev.springprojects.LibraryJournal.repository.PersonRepository;
import ru.mikhalev.springprojects.LibraryJournal.service.functional.api.PersonService;

import java.util.List;

/**
 * @author Ivan Mikhalev
 */

@Service
@RequiredArgsConstructor
public class PersonImpl implements PersonService {
    private final PersonRepository personRepository;

    @Override
    public void addPerson(Person person) {
        personRepository.save(person);
    }

    @Override
    public void editPerson(int id, Person updatedPerson) {
        Person person = Person.getPersonByOptional(personRepository.findById(id));
        person.setFullName(updatedPerson.getFullName());
        person.setBirthYear(updatedPerson.getBirthYear());
        personRepository.save(person);
    }

    @Override
    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    @Override
    public List<Person> showAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person showOnePerson(int id) {
        return personRepository.getReferenceById(id);
    }
}
