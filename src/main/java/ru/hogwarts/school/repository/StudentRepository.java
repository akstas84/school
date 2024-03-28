package ru.hogwarts.school.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.model.Student;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public interface StudentRepository extends JpaRepository<Student, Long> {
    default Map<Long, Student> findAllAsMapUsingCollection() {
        return findAll().stream()
                .collect(Collectors.toMap(Student::getId, Function.identity()));
    }


    List<Student> findByAgeBetween(int min, int max);
}