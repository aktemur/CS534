package decorator.starbuzz;
 
public class Whip extends Condiment {
    public Whip(Beverage beverage) {
        super(beverage);
    }
 
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
 
    protected double getCondimentCost() {
        return .10;
    }
}
