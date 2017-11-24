package visitor.fruitBasket.v1;

public class Grapes extends Fruit {
    public Grapes(int count) {
        super(count * 2);
    }

    @Override
    public void accept(FruitVisitor visitor) {
        visitor.visitGrapes(this);
    }
}
