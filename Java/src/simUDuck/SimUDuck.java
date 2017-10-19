public class SimUDuck {
    public static void main(String[] args) {
        Duck mallard = new MallardDuck();
        Duck redHead = new RedHeadDuck();
        Duck rubber = new RubberDuck();
        Duck decoy = new DecoyDuck();

        mallard.performFly();
        mallard.performQuack();
        System.out.println();

        redHead.performFly();
        redHead.performQuack();
        System.out.println();

        rubber.performFly();
        rubber.performQuack();
        System.out.println();

        decoy.performFly();
        decoy.performQuack();
        System.out.println();

        rubber.setFlyBehaviour(new FlyWithWings());
        rubber.performFly();
        System.out.println();

        mallard.setQuackBehaviour(new Mute());
        mallard.performQuack();
        System.out.println();

        rubber.setFlyBehaviour(new FlyWithRocket());
        rubber.performFly();
        System.out.println();        

    }
}
