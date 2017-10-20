package strategy.v1;

public class SimUDuck {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        Duck redHead = new RedHeadDuck();
        Duck rubber = new RubberDuck();
        Duck decoy = new DecoyDuck();

        mallard.fly();
        mallard.quack();
        System.out.println();

        redHead.fly();
        redHead.quack();
        System.out.println();

        rubber.fly();
        rubber.quack();
        System.out.println();

        decoy.fly();
        decoy.quack();
        System.out.println();

        rubber.setFlyBehaviour(new FlyWithWings());
        rubber.fly();
        System.out.println();

        mallard.setQuackBehaviour(new Mute());
        mallard.quack();
        System.out.println();

        rubber.setFlyBehaviour(new FlyWithRocket());
        rubber.fly();
        System.out.println();        

    }
}
