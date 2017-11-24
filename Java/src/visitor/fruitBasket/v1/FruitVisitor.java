package visitor.fruitBasket.v1;

public interface FruitVisitor {

    public void visitApple(Apple apple);

    public void visitBanana(Banana banana);

    public void visitOrange(Orange orange);

    public void visitGrapes(Grapes grapes);
}
