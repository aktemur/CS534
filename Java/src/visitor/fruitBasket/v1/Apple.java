package visitor.fruitBasket.v1;

public class Apple extends Fruit {

    public Apple(int weight) {
        super(weight);
    }

    @Override
    public void accept(FruitVisitor visitor) {
        visitor.visitApple(this);
    }
}
