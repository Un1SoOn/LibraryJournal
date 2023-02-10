package ru.mikhalev.springprojects.LibraryJournal.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.mikhalev.springprojects.LibraryJournal.controller.api.PeopleApi;
import ru.mikhalev.springprojects.LibraryJournal.model.Person;
import ru.mikhalev.springprojects.LibraryJournal.service.functional.impl.PersonImpl;

/**
 * @author Ivan Mikhalev
 */

@Controller
@RequestMapping("/people")
@RequiredArgsConstructor
public class PeopleController implements PeopleApi {
    private final PersonImpl personService;

    @Override
    @GetMapping
    public String getAllPersons(Model model) {
        model.addAttribute("persons", personService.showAllPersons());
        return "peoples/allPeoples";
    }

    @Override
    @GetMapping("/new")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "/peoples/newPersonPage";
    }

    @Override
    @PostMapping("/new")
    public String newPerson(@ModelAttribute("person") Person person) {
        personService.addPerson(person);
        return "redirect:/people";
    }

    @Override
    @GetMapping("/{id}")
    public String showPerson(@PathVariable int id, Model model) {
        model.addAttribute("person", personService.showOnePerson(id));
        return "/peoples/showPersonPage";
    }

    @Override
    @GetMapping("/{id}/edit")
    public String editPerson(@PathVariable int id, Model model) {
        model.addAttribute("person", personService.showOnePerson(id));
        return "peoples/editPersonPage";
    }

    @Override
    @PostMapping("/{id}/edit")
    public String editPerson(int id, @ModelAttribute Person updatedPerson) {
        personService.editPerson(id, updatedPerson);
        return "redirect:/people";
    }

    @Override
    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable int id) {
        personService.deletePerson(id);
        return "redirect:/people";
    }
}
