package fruitBasket.v1;

public abstract class Fruit {
    private int weight;


    public Fruit(int weight) {
        this.weight = weight;
    }

    public double getCalories() {
        return getWeight() * getCaloriesPerGram();
    }

    protected abstract double getCaloriesPerGram();

    public double getCost() {
        return getWeight() * getCostPerKG() / 1000;
    }

    protected abstract double getCostPerKG();

    public int getWeight() {
        return weight;
    }
}
