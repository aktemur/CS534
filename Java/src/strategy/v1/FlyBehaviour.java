package strategy.v1;

public interface FlyBehaviour {
    public void fly();
}

class FlyWithWings implements FlyBehaviour {
    public void fly() {
        System.out.println("Flying with wings...");
    }
}

class FlyNoWay implements FlyBehaviour {
    public void fly() {
        System.out.println("Can't fly.");
    }
}

class FlyWithRocket implements FlyBehaviour {
    public void fly() {
        System.out.println("Rocket fly...");
    }
}
