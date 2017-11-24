package visitor.fruitBasket.v1;

public class Orange extends Fruit {
    public Orange(int weight) {
        super(weight);
    }

    @Override
    public void accept(FruitVisitor visitor) {
        visitor.visitOrange(this);
    }
}
