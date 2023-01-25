package ru.mikhalev.springprojects.LibraryJournal.controller.api;

import org.springframework.web.bind.annotation.*;

@RequestMapping("/people")
public interface PeopleApi {
    @GetMapping()
    String getAllPersons();

    @GetMapping("/new")
    String newPerson();

    @PostMapping()
    String createPerson();

    @GetMapping("/{id}/edit")
    String editPerson(@PathVariable("id") int id);

    @PatchMapping("{id}")
    String updatePerson(@PathVariable("id") int id);

    @DeleteMapping("{id}")
    String deletePerson(@PathVariable("id") int id);
}
