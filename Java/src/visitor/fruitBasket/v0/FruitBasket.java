package visitor.fruitBasket.v0;

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
        double sum = 0;
        for (Fruit fruit: fruits) {
            sum += fruit.getCalories();
        }
        return sum;
    }

    public int totalWeight() {
        int sum = 0;
        for (Fruit fruit: fruits) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public double totalCost() {
        double sum = 0;
        for (Fruit fruit: fruits) {
            sum += fruit.getCost();
        }
        return sum;
    }
}
