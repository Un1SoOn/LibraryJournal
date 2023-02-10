package ru.mikhalev.springprojects.LibraryJournal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author Ivan Mikhalev
 *
 * Класс, содержащий информацию о читателе
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Entity
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "full_name")
    @NotNull(message="ФИО читателя не может быть пустым")
    @Size(min = 5, max = 50, message="Длина ФИО не может быть меньше 5 и больше 50 символов")
    private String fullName;

    @Column(name = "birth_year")
    @Min(value = 1900, message="Год рождения не может быть меньше 1900")
    @Max(value = 2005, message="Год рождения не может быть больше 2005")
    private Integer birthYear;

    public static Person getPersonByOptional(Optional<Person> person) {
        Person finalPerson = null;
        try {
            finalPerson = person.orElseThrow();
        } catch (NoSuchElementException ex) {
            log.error(ex.getMessage());
        }
        return finalPerson;
    }
}
