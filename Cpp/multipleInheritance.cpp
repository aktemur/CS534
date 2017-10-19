#include <iostream>

using namespace std;

class Person {
public:
  int name;

  Person() {
    cout << "Person ctor.\n";
    name = 1;
  }

  ~Person() {
    cout << "Person dtor.\n";
  }
};

class Instructor : public Person {
public:
  int age;

  Instructor() {
    cout << "Instructor ctor.\n";
  }

  ~Instructor() {
    cout << "Instructor dtor.\n";
  }
};

class Student : public Person {
public:
  int age;

  Student() {
    cout << "Student ctor.\n";
  }

  ~Student() {
    cout << "Student dtor.\n";
  }
};

class GraduateStudent : public Student, public Instructor {
public:
  GraduateStudent() {
    cout << "GraduateStudent ctor.\n";
    Instructor::name = 4; // Which name? Ambiguity has to be manually resolved
    Student::age = 5;     // Which age? Ambiguity has to be manually resolved
  }

  ~GraduateStudent() {
    cout << "GraduateStudent dtor.\n";
  }
};

int main() {
  cout << "-- Creating a GradStudent.\n";
  GraduateStudent GraduateStudent;
  cout << "-- End.\n";  
}
