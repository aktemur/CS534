package zoo.v0;

import java.util.*;

public class Zoo {
    private List animals = new ArrayList();

    public void add(Object animal) {
        animals.add(animal);
    }

    public void allSounds() {
        for (Object animal: animals) {
            String sound;
            if (animal instanceof Cat) {
                sound = ((Cat)animal).sound();
            } else if (animal instanceof Dog) {
                sound = ((Dog)animal).sound();
            } else {
                sound = ((Elephant)animal).sound();
            }
            System.out.println(sound);
        }
    }

    public void allLegs() {
        int sum = 0;
        for (Object animal: animals) {
            int legs = 0;
            if (animal instanceof Cat) {
                legs = ((Cat)animal).numLegs();
            } else if (animal instanceof Dog) {
                legs = ((Dog)animal).numLegs();
            } else {
                legs = ((Elephant)animal).numLegs();
            }
            sum += legs;
        }
        System.out.println("Counted " + sum + " legs.");
    }
}
