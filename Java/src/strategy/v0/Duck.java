package strategy.v0;

public abstract class Duck {
    public void swim() {
        System.out.println("Swimming...");
    }

    public abstract void display();

    public void quack() {
        System.out.println("Vak vak.");
    }

    public void fly() {
        System.out.println("Fly with wings.");
    }
}

class MallardDuck extends Duck {
    MallardDuck() {
    }

    public void display() {
        System.out.println("Mallard display.");
    }
}

class RedHeadDuck extends Duck {
    RedHeadDuck() {
    }

    public void display() {
        System.out.println("RedHead display.");
    }
}




















                          
