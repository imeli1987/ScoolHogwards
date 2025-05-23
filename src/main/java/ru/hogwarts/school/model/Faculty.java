package ru.hogwarts.school.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Faculty{

    @Id
    @GeneratedValue
    private long id;

    private String name;
    private String color;

    @OneToMany(mappedBy = "faculty")
    private Collection<Student> students;

    @Override
    public String toString(){
        return "Faculty{" +
                "id=" + id + '\'' +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals( Object o ){
        if (o == null || getClass() != o.getClass()) return false;
        Faculty faculty = (Faculty) o;
        return Objects.equals( name, faculty.name ) && Objects.equals( color, faculty.color );
    }

    @Override
    public int hashCode(){
        return Objects.hash( name, color );
    }

    public long getId(){
        return id;
    }

    public void setId( long id ){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public String getColor(){
        return color;
    }

    public void setColor( String color ){
        this.color = color;
    }
}
