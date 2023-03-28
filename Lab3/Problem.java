import java.util.*;

class Student{
    private String name;
    private String lastName;
    public Student(String name, String lastName){
        this.name = name;
        this.lastName = lastName;
    }
    public String getName(){
        return  this.name;
    }
    public String getLastName(){
        return this.lastName;
    }
}

class Course {
    private String IdCourse;
    private Map<Integer, Student> list;
    public Course(String IdCourse) {
        this.IdCourse = IdCourse;
        this.list = new LinkedHashMap<>();
    }

    public String getIdCourse() {
        return IdCourse;
    }
    // Agregar los métodos requeridos aquí
}

public class Problem {
    public static void main(String[] args) {
        System.out.println("Completar código");
    }
}
