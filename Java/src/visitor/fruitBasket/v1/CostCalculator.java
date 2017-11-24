package visitor.fruitBasket.v1;

public class CostCalculator implements FruitVisitor {
    private double totalCost = 0;

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public void visitApple(Apple apple) {
        totalCost += 2.9 * apple.getWeight();
    }

    @Override
    public void visitBanana(Banana banana) {
        totalCost += 1.9 * banana.getWeight();
    }

    @Override
    public void visitOrange(Orange orange) {
        totalCost += 3.7 * orange.getWeight();
    }

    @Override
    public void visitGrapes(Grapes grapes) {
        totalCost += 6.0 * grapes.getWeight();
    }
}
