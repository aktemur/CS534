package variance;

import java.util.*;

class Person {
    String name;
}

class Student extends Person {
    double gpa;
}

public class Variance {
    // Co-variance
    public static void printPeople(Vector<? extends Person> people) {
        for(Person p: people) {
            System.out.println(p);
        }
    }

    // Contra-variance
    public static void addNewStudent(Vector<? super Student> students) {
        students.add(new Student());
    }

    // Co-variance does NOT allow WRITE operation
    public static void printPeopleBAD(Vector<? extends Person> people) {
        // The statement below gives a type error
        // people.add(new Person());
    }

    // Contra-variance does NOT allow READ operation
    public static void addNewStudentBAD(Vector<? super Student> students) {
        // The statement below gives a type error
        // System.out.println(students.get(0).gpa);
    }

    public static void main(String[] args) {
        Vector<Student> students = new Vector<Student>();
        students.add(new Student());

        Vector<Person> people = new Vector<Person>();
        people.add(new Person());

        addNewStudent(people);
        printPeople(students);
    }
}
