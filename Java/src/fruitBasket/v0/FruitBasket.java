package fruitBasket.v0;

import java.util.LinkedList;
import java.util.List;

public class FruitBasket {
    private List<Fruit> fruits = new LinkedList<Fruit>();

    public void add(Fruit f) {
        fruits.add(f);
    }

    public Fruit take() {
        return fruits.remove(0);
    }

    public double totalCalories() {
        return 0;
    }

    public int totalWeight() {
        return 0;
    }

    public double totalCost() {
        return 0;
    }
}
