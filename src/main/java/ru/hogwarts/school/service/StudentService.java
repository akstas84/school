package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    Map<Long, Student> students = new HashMap<>();
    long incrId;


    public Student createStudent(Student student) {
        student.setId(++incrId);
        students.put(incrId, student);
        return student;
    }

    public Student findStudent(long id) {
        if (students.containsKey(id)) {
            return students.get(id);
        }
        return null;
    }

    public Student editeStudent(Student student) {
        if (students.containsKey(student.getId())) {
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student deleteStudent(long id) {
        return students.remove(id);
    }

    public Map<Long, Student> filterStudent(long id) {
        Map<Long, Student> filteredMap = students.entrySet().stream()
                .filter(st -> st.getValue().getAge() == id)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return filteredMap;
    }
}
