package ru.hogwarts.school.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.repository.FacultyRepository;

import java.util.Collection;

@Service
public class FacultyService{

    private final FacultyRepository facultyRepository;

    public FacultyService( FacultyRepository facultyRepository ){
        this.facultyRepository = facultyRepository;
    }

    public Faculty createFaculty( Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id){
        facultyRepository.deleteById(id);
    }

    public Faculty findFaculty(long id){
        return facultyRepository.findById( id ).get();
    }

    public Faculty editFaculty(Faculty faculty){
        return facultyRepository.save(faculty);
    }

    public Collection<Faculty> getAllFaculty(){
        return facultyRepository.findAll();
    }

    public Collection<Faculty> filteredFacultyByColor(String color){
        return facultyRepository.findByColor( color );
    }
}























































