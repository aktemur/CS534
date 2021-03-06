package decorator.starbuzz;

public abstract class Condiment extends Beverage {
    Beverage beverage;

    public Condiment(Beverage beverage) {
        this.beverage = beverage;
    }
    
    public abstract String getDescription();

    public double cost() {
        return getCondimentCost() + beverage.cost();
    }

    protected abstract double getCondimentCost();
}
