package zoo.v3;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private List<Animal> animals = new ArrayList<Animal>();

    public void add(Animal animal) {
        animals.add(animal);
    }

    public void allSounds() {
        // Polymorphism
        for (Animal animal: animals) {
            System.out.println(animal.sound());
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
