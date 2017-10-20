package strategy.v0;

public class SimUDuck {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        Duck redHead = new RedHeadDuck();

        mallard.fly();
        mallard.quack();
        System.out.println();

        redHead.fly();
        redHead.quack();
        System.out.println();
    }
}
