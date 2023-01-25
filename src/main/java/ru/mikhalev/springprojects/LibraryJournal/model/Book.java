package ru.mikhalev.springprojects.LibraryJournal.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ivan Mikhalev
 *
 * Класс, содержащий информацию о книге
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    @NotNull(message="Название книги не может отсутствовать")
    @Size(min = 2, max = 50, message="Название книги не может быть меньше 2 и больше 50 символов")
    private String title;
    @NotNull(message="Имя и фамилия автора не может отсутствовать")
    @Size(min = 5, max = 50, message="Имя и фамилия автора не может быть меньше 5 и больше 50 символов")
    private String authorFullName;
    @Min(value = 1900, message="Год издания не может быть меньше 1900")
    @Max(value = 2023, message="Год издания не может быть больше 2023")
    private Integer publicationYear;
}
