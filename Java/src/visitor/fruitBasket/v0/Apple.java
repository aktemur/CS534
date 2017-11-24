package visitor.fruitBasket.v0;

public class Apple extends Fruit {

    public Apple(int weight) {
        super(weight);
    }

    public double getCaloriesPerGram() {
        return 2.8;
    }

    public double getCostPerKG() {
        return 2.0;
    }
}
