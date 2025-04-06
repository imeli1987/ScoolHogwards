package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController{
    private final StudentService studentService;

    public StudentController( StudentService studentService ){
        this.studentService = studentService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getStudent( @PathVariable long id){
        Student student = studentService.findStudent( id );
        if (student == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok( student );
    }

    @GetMapping
    public ResponseEntity<Collection<Student>> getAllStudents(){
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @GetMapping("age/{age}")
    public ResponseEntity <Collection<Student>> getFilteredStudentsByAge( @PathVariable int age){
        Collection<Student> findStudentByAge = studentService.findByAge( age );
        if (findStudentByAge != null){
            return ResponseEntity.ok( findStudentByAge );
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Student createStudent( @RequestBody Student student){
        return studentService.createStudent( student );
    }

    @PutMapping
    public ResponseEntity<Student> editStudent( @RequestBody Student student){
        Student foundStudent = studentService.updateStudent( student );
        if (foundStudent == null){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok( foundStudent );
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Student> deleteStudent( @PathVariable long id){
        studentService.deleteStudent( id );
        return ResponseEntity.ok().build();
    }

}




























