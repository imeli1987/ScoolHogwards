package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class StudentService{

    private final HashMap<Long, Student> students = new HashMap<>();
    private long lastId = 0;

    public Student createStudent(Student student) {
        if (student != null) {
            student.setId(++lastId);
            students.put(student.getId(), student);
            return student;
        } else {
            return null;
        }
    }

    public Student getStudent(long id) {
        if (students.containsKey(id)) {
            return students.get(id);
        } else {
            return null;
        }
    }

    public Student deleteStudent(long id) {
        return students.remove(id);
    }

    public Student updateStudent(Student student) {
        if (students.containsKey( student.getId( ))){
            students.put(student.getId(), student);
            return student;
        }
        return null;
    }

    public Student findStudent(long id) {
        return students.get(id);
    }

    public Collection<Student> getAllStudents() {
        return students.values();
    }

    public List<Student> filterByAge(int age) {
        List<Student> filteredStudents;
        filteredStudents = students.values().stream()
                .filter( x -> x.getAge() == age )
                .toList();
        return filteredStudents;
    }

}














