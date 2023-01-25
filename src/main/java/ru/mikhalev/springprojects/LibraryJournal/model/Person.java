package ru.mikhalev.springprojects.LibraryJournal.dao;

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
 * Класс, содержащий информацию о читателе
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDAO {
    @NotNull(message="Фамилия и отчество читателя не может быть пустым")
    @Size(min = 5, max = 50, message="Длина имени и отчества не может быть меньше 5 и больше 50 символов")
    private String fullName;
    @Min(value = 1900, message="Год рождения не может быть меньше 1900")
    @Max(value = 2005, message="Год рождения не может быть больше 2005")
    private Integer birthYear;
}