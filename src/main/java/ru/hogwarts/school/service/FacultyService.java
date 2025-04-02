package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.model.Faculty;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Service
public class FacultyService{

    private final HashMap<Long, Faculty> faculties = new HashMap<>();
    private long lastId = 0;

    public Faculty createFaculty(Faculty faculty){
        if (faculty != null){
            faculty.setId(++lastId);
            faculties.put(faculty.getId(), faculty);
            return faculty;
        } else{
            return null;
        }
    }

    public Faculty deleteFaculty(long id){
        return faculties.remove(id);
    }

    public Faculty findFaculty(long id){
        return faculties.get(id);
    }

    public Faculty editFaculty(Faculty faculty){
        if (faculty != null){
            faculties.put(faculty.getId(), faculty);
            return faculty;
        } else {
            return null;
        }
    }

    public Collection<Faculty> getAllFaculty(){
        return faculties.values();
    }

    public Collection<Faculty> filteredFacultyByColor(String color){
        return faculties.values().stream().filter( x -> x.getColor().equals(color)).toList();
    }
}























































