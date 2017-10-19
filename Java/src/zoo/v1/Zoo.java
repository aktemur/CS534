package zoo.v1;

import java.util.*;

public class Zoo {
    private List<Animal> animals = new ArrayList<Animal>();

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void allSounds() {
        // We see a use of polymorphism below
        // Each animal is accessed through the
        // Animal interface, although the objects
        // are of different types, such as Cat and Dog.
        for (Animal animal: animals) {
            String sound = animal.sound();
            System.out.println(sound);
        }
    }

    public void allLegs() {
        int sum = 0;
        for (Animal animal: animals) {
            sum += animal.numLegs();
        }
        System.out.println("Counted " + sum + " legs.");
    }
}
