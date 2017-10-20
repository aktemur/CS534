package decorator.starbuzz;

public class Soy extends Condiment {
    public Soy(Beverage beverage) {
        super(beverage);
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    protected double getCondimentCost() {
        return .15;
    }
}
