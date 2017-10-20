package strategy.v1;

public interface QuackBehaviour {
    public void quack();
}

class Quack implements QuackBehaviour {
    public void quack() {
        System.out.println("Vak vak.");
    }
}

class Squeak implements QuackBehaviour {
    public void quack() {
        System.out.println("Squeak...");
    }
}

class Mute implements QuackBehaviour {
    public void quack() {
        System.out.println("----");
    }
}

