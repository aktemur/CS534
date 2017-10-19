package factory.pizza;

public class PizzaTestDrive {
 
    public static void main(String[] args) {
        PizzaStore store = new PizzaStore();

        Pizza pizza = store.orderPizza("cheese");
        System.out.println("We ordered a " + pizza.getName() + "\n");
        System.out.println(pizza);
 
        pizza = store.orderPizza("veggie");
        System.out.println("We ordered a " + pizza.getName() + "\n");
        System.out.println(pizza);
    }
}
