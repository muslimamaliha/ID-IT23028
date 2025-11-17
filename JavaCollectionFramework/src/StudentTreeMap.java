import java.util.*;

class Student {
    String name;
    String dept;

    Student(String name, String dept) {
        this.name = name;
        this.dept = dept;
    }
}

public class StudentTreeMap {

    public static void main(String[] args) {
        TreeMap<Integer, Student> students = new TreeMap<>();

        students.put(101, new Student("Alice", "CSE"));
        students.put(105, new Student("Bob", "EEE"));
        students.put(103, new Student("John", "ME"));

        System.out.println("Student Details:");
        for (Map.Entry<Integer, Student> e : students.entrySet()) {
            Student s = e.getValue();
            System.out.println(e.getKey() + ": " + s.name + " (" + s.dept + ")");
        }
    }
}
