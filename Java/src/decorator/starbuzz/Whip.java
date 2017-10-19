package decorator.starbuzz;
 
public class Whip extends Condiment {
    public Whip(Beverage beverage) {
        super(beverage);
    }
 
    public String getDescription() {
        return beverage.getDescription() + ", Whip";
    }
 
    public double cost() {
        return .10 + beverage.cost();
    }
}
