package decorator.starbuzz;

public class Mocha extends Condiment {
    public Mocha(Beverage beverage) {
        super(beverage);
    }
 
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
 
    public double getCondimentCost() {
        return .20 + beverage.cost();
    }
}
