package fruitBasket.v1;

public class Banana extends Fruit {
    public Banana(int weight) {
        super(weight);
    }

    public double getCaloriesPerGram() {
        return 3.2;
    }

    public double getCostPerKG() {
        return 4.0;
    }
}
