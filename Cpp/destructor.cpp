#include <iostream>

using namespace std;

class Dummy {
public:
  ~Dummy() {
    cout << "Dummy is gone\n";
  }
};

class Person {
public:
  int age;

  Person() {
    cout << "Person ctor.\n";
    age = 42;
  }

  ~Person() {
    cout << "Person dtor\n";
  }
};

class Instructor : public Person {
public:
  int age;
  Dummy *dummy;

  Instructor() {
    cout << "Instructor ctor.\n";
    dummy = new Dummy();
  }

  ~Instructor() {
    cout << "Instructor dtor.\n";
    delete dummy;
  }
};

int main() {
  cout << "-- Creating an Instructor.\n";
  Person *person = new Instructor();
  cout << "-- End.\n"; 
  delete person;
  // ATTENTION: deleting the person object does NOT call the 
  // Instructor destructor when ~Person() is non-virtual.
  // This causes the dummy object to leak the memory.
  // Lesson: Always declare the destructors virtual. 
}









