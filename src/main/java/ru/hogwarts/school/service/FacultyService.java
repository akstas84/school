package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Map;
import java.util.stream.Collectors;


@Service
public class FacultyService {

    private FacultyRepository facultyRepository;

    public FacultyService(FacultyRepository facultyRepository) {
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty editeFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public void findByName(String name) {
        facultyRepository.findByName(name);
    }


    public Map<Long, Faculty> colorFilterFaculty(String colour) {
        Map<Long, Faculty> filteredFaculties = facultyRepository.findAllAsMapUsingCollection().entrySet().stream()
                .filter(f -> f.getValue().getColor().equals(colour))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return filteredFaculties;
    }

    public void findByNameOrColor(String str){
        facultyRepository.findByNameIgnoreCaseOrColorIgnoreCase(str);
    }

}
