package visitor.fruitBasket.v1;

public class Banana extends Fruit {
    public Banana(int weight) {
        super(weight);
    }

    @Override
    public void accept(FruitVisitor visitor) {
        visitor.visitBanana(this);
    }
}
