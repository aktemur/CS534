package shallowVsDeepCopy;

class Apple {
    int weight;

    Apple(int w) {
        weight = w;
    }

    Apple deepCopy() {
        Apple copy = new Apple(weight);
        return copy;
    }
}

class Basket {
    Apple apple;

    Basket(Apple a) {
        apple = a;
    }

    Basket shallowCopy() {
        Basket copy = new Basket(this.apple);
        return copy;
    }

    Basket deepCopy() {
        Basket copy = new Basket(this.apple.deepCopy());
        return copy;
    }
}

public class ShallowVsDeep {
    public static void main(String[] args) {
        Apple a = new Apple(100);
        Basket b1 = new Basket(a);

        System.out.println(b1.apple.weight); // 100

        Basket b2 = b1.deepCopy();
        b2.apple.weight = 200;
        System.out.println(b1.apple.weight); // 100

        Basket b3 = b1.shallowCopy();
        b3.apple.weight = 300;
        System.out.println(b1.apple.weight); // 300       
    }
}