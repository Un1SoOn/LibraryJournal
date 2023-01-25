package ru.mikhalev.springprojects.LibraryJournal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.mikhalev.springprojects.LibraryJournal.controller.api.PeopleApi;
import ru.mikhalev.springprojects.LibraryJournal.service.functional.api.PersonService;

/**
 * @author Ivan Mikhalev
 */

@Controller
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleController implements PeopleApi {
    private final PersonService personService;
    @GetMapping()
    public String getAllPeoples() {
        return "peoples/allPeoples";
    }

    @Override
    public String getAllPersons() {
        return null;
    }

    @Override
    public String newPerson() {
        return null;
    }

    @Override
    public String createPerson() {
        return null;
    }

    @Override
    public String editPerson(int id) {
        return null;
    }

    @Override
    public String updatePerson(int id) {
        return null;
    }

    @Override
    public String deletePerson(int id) {
        return null;
    }
}
