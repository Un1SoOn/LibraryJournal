package ru.mikhalev.springprojects.LibraryJournal.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.TypeMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import ru.mikhalev.springprojects.LibraryJournal.controller.api.PeopleApi;
import ru.mikhalev.springprojects.LibraryJournal.model.Person;
import ru.mikhalev.springprojects.LibraryJournal.service.functional.impl.PersonService;

/**
 * @author Ivan Mikhalev
 */

@Controller
@RequestMapping("/people")
@RequiredArgsConstructor
@Slf4j
public class PeopleController implements PeopleApi {
    private final PersonService personService;

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
    public String newPerson(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
        try{
            Integer.parseInt(person.getBirthYear().toString());
        } catch (TypeMismatchException ex) {
            bindingResult.addError(new ObjectError("error", "Год рождения должен быть числом"));
        }
        if(bindingResult.hasErrors())
            return "peoples/newPersonPage";

        personService.addPerson(person);
        return "redirect:/people";
    }

    @Override
    @GetMapping("/{id}")
    public String showPerson(@PathVariable int id, Model model) {
        model.addAttribute("person", personService.showOnePerson(id));
        model.addAttribute("books", personService.getBooksByPersonId(id));
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
    public String editPerson(int id, @ModelAttribute @Valid Person updatedPerson, BindingResult bindingResult) {
        if(bindingResult.hasErrors())
            return "peoples/editPersonPage";
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
