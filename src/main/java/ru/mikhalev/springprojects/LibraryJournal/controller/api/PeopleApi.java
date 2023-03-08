package ru.mikhalev.springprojects.LibraryJournal.controller.api;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mikhalev.springprojects.LibraryJournal.model.Person;

@RequestMapping("/people")
public interface PeopleApi {
    @GetMapping()
    String getAllPersons(Model model);

    @GetMapping("/new")
    String newPerson(Model model);

    @GetMapping("/{id}")
    String showPerson(@PathVariable int id, Model model);

    @GetMapping("/{id}/edit")
    String editPerson(@PathVariable("id") int id, Model model);

    @PostMapping("/{id}/edit")
    String editPerson(@PathVariable("id") int id, Person person, BindingResult bindingResult);

    @DeleteMapping("/{id}")
    String deletePerson(@PathVariable("id") int id);

    @PostMapping()
    String newPerson(@ModelAttribute("person") Person person, BindingResult bindingResult);
}
