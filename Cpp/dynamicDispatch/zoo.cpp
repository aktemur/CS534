#include <iostream>

/* This is a sample program to test dynamic dispatch. 
   Define the print and sound methods as virtual
   and non-virtual, and observe the change in the output
*/

#include <iostream>
using namespace std;

class Animal {
public:
  virtual void print() {
    cout << "Animal ";
    sound();
  }

  virtual void sound() {
    cout << "A ";
  }
};

class Mammal : public Animal {
public:
  virtual void print() {
    cout << "Mammal ";
    Animal:: print();
  }

  virtual void sound() {
    cout << "M ";
  }
};

class Cat : public Mammal {
public:
  virtual void print() {
    cout << "Miyav ";
    sound();
  } 
};

class Dog : public Mammal {
public:
   virtual void sound() {
    cout << "Hav ";
  }
};

int main() {
  Cat *cat = new Cat();
  Dog *dog = new Dog();
  Mammal *ma1 = new Cat();
  Mammal *ma2 = new Dog();
  Mammal *ma3 = new Mammal();
      
  cat->print(); cout << "\n";
  dog->print(); cout << "\n";
  ma1->print(); cout << "\n";
  ma2->print(); cout << "\n";
  ma3->print(); cout << "\n";
  return 0;
}
