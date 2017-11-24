package visitor.fruitBasket.v1;

public class Main {
    public static void main(String[] args) {
        FruitBasket basket = new FruitBasket();

        basket.add(new Apple(15));
        basket.add(new Apple(20));
        basket.add(new Orange(18));
        basket.add(new Orange(10));
        basket.add(new Apple(12));
        basket.add(new Grapes(40));
        basket.add(new Grapes(30));

        CalorieCalculator calorieCalculator = new CalorieCalculator();
        basket.accept(calorieCalculator);
        double totalCalories = calorieCalculator.getTotalCalories();

        CostCalculator costCalculator = new CostCalculator();
        basket.accept(costCalculator);
        double totalCost = costCalculator.getTotalCost();

        System.out.println("Cal: " + totalCalories);
        //System.out.println("Weight: " + basket.totalWeight());
        System.out.println("Cost: " + totalCost);

    }
}










