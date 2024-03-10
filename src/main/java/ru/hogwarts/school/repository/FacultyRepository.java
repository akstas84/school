package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    default Map<Long, Faculty> findAllAsMapUsingCollection() {
        return findAll().stream()
                .collect(Collectors.toMap(Faculty::getId, Function.identity()));
    }
}
