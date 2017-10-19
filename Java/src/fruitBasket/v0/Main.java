package fruitBasket.v0;

public class Main {
    public static void main(String[] args) {
        FruitBasket basket = new FruitBasket();

        basket.add(new Apple(100));
        basket.add(new Apple(130));
        basket.add(new Orange(180));
        basket.add(new Orange(150));
        basket.add(new Apple(120));
        // basket.add(new Grapes(40));
        // basket.add(new Grapes(60));

        System.out.println("Cal: " + basket.totalCalories());
        System.out.println("Weight: " + basket.totalWeight());
        System.out.println("Cost: " + basket.totalCost());

    }
}










