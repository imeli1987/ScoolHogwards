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
    public ResponseEntity<Collection<Faculty>> getAllFaculty(@RequestParam(required = false) String name, @RequestParam(required = false) String color){
        if (name!=null && name.isEmpty() ){
            return ResponseEntity.ok( facultyService.findFacultyByName( name ) );
        }
        if (color!=null && color.isEmpty() ){
            return ResponseEntity.ok( facultyService.findFacultyByColor( color ) );
        }
        return ResponseEntity.ok( facultyService.getAllFaculty() );
    }

    @GetMapping("/color/{color}")
    public ResponseEntity<Faculty> getFilteredFacultyByColor(@PathVariable String color){
        Faculty filteredFaculty = facultyService.filteredFacultyByColor( color );
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

    @PutMapping("{id}")
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

    @GetMapping("/students/{name}")
    public ResponseEntity<Faculty> getFacultiesByStudentsName(@PathVariable String name){
        Faculty faculty = facultyService.getFacultiesByStudentsName( name );
        if ( faculty == null ){
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(faculty);
        }
    }

    @GetMapping("/longestName")
    public ResponseEntity<String> getFacultyLongestName() {
        Faculty faculty = facultyService.getFacultyLongestName();
        if (faculty == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(faculty.getName());
        }
    }

    @GetMapping("/example4")
    public Long example4(){
        return facultyService.example4();
    }

}
