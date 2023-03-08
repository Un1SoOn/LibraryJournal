package ru.mikhalev.springprojects.LibraryJournal.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author Ivan Mikhalev
 *
 * Класс, содержащий информацию о книге
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Entity
@Table(name="book")
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    @NotNull(message="Название книги не может отсутствовать")
    @Size(min = 2, max = 50, message="Название книги не может быть меньше 2 и больше 50 символов")
    private String title;

    @Column(name = "person_id")
    private Integer personId;

    @Column(name = "author_full_name")
    @NotNull(message = "Имя и фамилия автора не может отсутствовать")
    @Size(min = 5, max = 50, message = "Имя и фамилия автора не может быть меньше 5 и больше 50 символов")
    private String authorFullName;

    @Column(name = "publication_year")
    @Min(value = 1900, message="Год издания не может быть меньше 1900")
    @Max(value = 2023, message="Год издания не может быть больше 2023")
    private Integer publicationYear;

    public static Book getBookByOptional(Optional<Book> book) {
        Book finalBook = null;
        try {
            finalBook = book.orElseThrow();
        } catch (NoSuchElementException ex) {
            log.error(ex.getMessage());
        }
        return finalBook;
    }
}
