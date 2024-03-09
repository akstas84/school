package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class FacultyService {

    Map<Long, Faculty> faculties = new HashMap<>();

    long incrId;

    public Faculty createFaculty(Faculty faculty) {
        faculty.setId(++incrId);
        faculties.put(incrId, faculty);
        return faculty;
    }

    public Faculty findFaculty(long id) {
        if (faculties.containsKey(id)) {
            return faculties.get(id);
        }
        return null;
    }

    public Faculty editeFaculty(Faculty faculty) {
        if (faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        return null;
    }

    public Faculty deleteFaculty(long id) {
        return faculties.remove(id);
    }

    public Map<Long, Faculty> colorFilterFaculty(String colour) {
        Map<Long, Faculty> filteredFaculties = faculties.entrySet().stream()
                .filter(f -> f.getValue().getColor().equals(colour))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return filteredFaculties;
    }


}
