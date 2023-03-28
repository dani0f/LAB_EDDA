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

class Course{
    private String IdCourse;
    private Map<Integer, Student> list;

    public Course(String IdCourse){
        this.IdCourse = IdCourse;
        this.list = new LinkedHashMap<>();
    }

    public String getIdCourse(){
        return IdCourse;
    }

    public boolean verifyStudent(int number){
        return this.list.get(number) != null;
    }

    public void insertStudent(int number, Student e){
        if(!verifyStudent(number)){
            this.list.put(number, e);
        } else {
            System.out.println("El estudiante ya existe");
        }
    }

    public void printList(){
        if(this.list.size() == 0){
            System.out.println("Lista vacía");
        } else {
            Iterator<Integer> it = this.list.keySet().iterator();
            while(it.hasNext()){
                Integer key = it.next();
                Student student = this.list.get(key);
                System.out.println(student.getName()+" "+student.getLastName());
            }
        }
    }

    public int CountEqualNames(String name){
        int counter = 0;
        if(this.list.size() == 0){
            System.out.println("La lista está vacía");
        } else {
            Iterator<Integer> it = this.list.keySet().iterator();
            while(it.hasNext()){
                Integer key = it.next();
                Student student = this.list.get(key);
                if(student.getName() == name){
                    counter += 1;
                }
            }
        }
        return counter;
    }
}

public class Solution {
    public static void main(String[] args) {
        Course course = new Course("1");
        course.insertStudent(1,new Student("benjamin","gerardo"));
        course.insertStudent(2,new Student("benjamin","fernandez"));
        course.insertStudent(3,new Student("benjamin","medina"));
        course.insertStudent(4,new Student("joaquin","fernandez"));
        course.printList();
        System.out.println(course.CountEqualNames("benjamin"));

    }
}
