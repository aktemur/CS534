package visitor.fruitBasket.v1;

public class CalorieCalculator implements FruitVisitor {
    private double totalCalories = 0;

    public double getTotalCalories() {
        return totalCalories;
    }

    @Override
    public void visitApple(Apple apple) {
        totalCalories += 2.8 * apple.getWeight();
    }

    @Override
    public void visitBanana(Banana banana) {
        totalCalories += 3.2 * banana.getWeight();
    }

    @Override
    public void visitOrange(Orange orange) {
        totalCalories += 3.8 * orange.getWeight();
    }

    @Override
    public void visitGrapes(Grapes grapes) {
        totalCalories += 4.0 * grapes.getWeight();
    }
}
