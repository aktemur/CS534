package decorator.starbuzz;

public class Milk extends Condiment {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    protected double getCondimentCost() {
        return .10;
    }
}
