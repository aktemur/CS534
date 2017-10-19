package fruitBasket.v1;

public class Grapes extends Fruit {
    public Grapes(int count) {
        super(count * 2);
    }

    public double getCaloriesPerGram() {
        return 4.0;
    }

    public double getCostPerKG() {
        return 6.0;
    }
}
