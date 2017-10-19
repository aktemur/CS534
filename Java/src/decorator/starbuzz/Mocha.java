package decorator.starbuzz;

public class Mocha extends Condiment {
    public Mocha(Beverage beverage) {
        super(beverage);
    }
 
    public String getDescription() {
        return beverage.getDescription() + ", Mocha";
    }
 
    public double cost() {
        return .20 + beverage.cost();
    }
}
