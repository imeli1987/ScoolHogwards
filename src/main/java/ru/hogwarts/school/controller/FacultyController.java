package ru.hogwarts.school.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;

import java.util.Collection;

@RestController
@RequestMapping("/faculty")
public class FacultyController{

    private final FacultyService facultyService;


    public FacultyController( FacultyService facultyService ){
        this.facultyService = facultyService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Faculty> getFaculty(@PathVariable long id){
        Faculty faculty = facultyService.findFaculty( id );
        if ( faculty == null ){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok( faculty );
        }
    }

    @GetMapping
    public ResponseEntity<Collection<Faculty>> getAllFaculty(){
        return ResponseEntity.ok( facultyService.getAllFaculty() );
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<Collection<Faculty>> getFilteredFacultyByColor(@PathVariable String color){
        Collection<Faculty> filteredFaculty = facultyService.filteredFacultyByColor( color );
        if ( filteredFaculty == null ){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok( filteredFaculty );
        }
    }

    @PostMapping
    public Faculty createFaculty(@RequestBody Faculty faculty){
        return facultyService.createFaculty( faculty );
    }

    @PutMapping
    public ResponseEntity<Faculty> editFaculty(@RequestBody Faculty faculty){
        Faculty foundFaculty = facultyService.editFaculty( faculty );
        if ( foundFaculty == null ){
            return ResponseEntity.ok( faculty );
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Faculty> deleteFaculty(@PathVariable long id){
        facultyService.deleteFaculty( id );
        return ResponseEntity.ok().build();
    }


}
