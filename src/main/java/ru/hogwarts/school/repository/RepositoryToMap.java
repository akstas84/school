package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface RepositoryToMap extends JpaRepository<Faculty, Long> { //ToDo findAllAsMapUsingCollection()

}
