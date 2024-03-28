package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {
    default Map<Long, Faculty> findAllAsMapUsingCollection() {
        return findAll().stream()
                .collect(Collectors.toMap(Faculty::getId, Function.identity()));
    }

    List<Faculty> findByName(String name);
    List<Faculty> findByNameAndId(String name, String id);
    List<Faculty> findByNameLike(String position);
    List<Faculty> findByNameIgnoreCaseOrColorIgnoreCase(String str);


}
