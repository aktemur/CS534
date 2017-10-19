package fruitBasket.v1;

public class Orange extends Fruit {
    public Orange(int weight) {
        super(weight);
    }

    public double getCaloriesPerGram() {
        return 3.8;
    }

    public double getCostPerKG() {
        return 1.5;
    }
}
