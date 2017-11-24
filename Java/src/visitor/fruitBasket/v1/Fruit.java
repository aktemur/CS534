package visitor.fruitBasket.v1;

public abstract class Fruit {
    private int weight;


    public Fruit(int weight) {
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public abstract void accept(FruitVisitor visitor);
}
