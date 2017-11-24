package visitor.fruitBasket.v1;

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

    public void accept(FruitVisitor visitor) {
        for (Fruit fruit: fruits) {
            fruit.accept(visitor);
        }
    }
}
