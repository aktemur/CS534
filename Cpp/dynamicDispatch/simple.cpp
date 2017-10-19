#include <iostream>
#include <stdlib.h>
#include <time.h>

using namespace std;

class Student {
public:
  virtual void crazy() {
    cout << "Student\n";
  }

  void sane() {
    cout << "Student\n";
  }
};
  
class Undergrad : public Student {
public:
  virtual void crazy() {
    cout << "Undergrad\n";
  }

  void sane() {
    cout << "Undergrad\n";
  }
};

class Grad : public Student {
public:
  virtual void crazy() {
    cout << "Grad\n";
  }

  void sane() {
    cout << "Grad\n";
  }
};

int main() {
  srand (time(NULL));
  Student *student;
  if (rand() % 2 == 0) {
    student = new Grad();
  } else {
    student = new Undergrad();
  }
  student->crazy();
  student->sane();
}
        
