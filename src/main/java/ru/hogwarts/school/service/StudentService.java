package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.*;

@Service
public class StudentService{

    private final StudentRepository studentRepository;

    public StudentService( StudentRepository studentRepository ){
        this.studentRepository = studentRepository;
    }

    public Student createStudent( Student student) {
        return studentRepository.save( student );
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById( id );
    }

    public Student updateStudent(Student student) {
        return studentRepository.save( student );
    }

    public Student findStudent(long id) {
        return studentRepository.findById( id ).get();
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public List<Student> findByAge(int age) {
        return studentRepository.findByAge( age );
    }

}














