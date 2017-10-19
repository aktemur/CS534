package zoo.v2;

public class Dog extends Animal {
    public Dog(String name, int color) {
        super(name, color);
    }

    public String sound() {
        return "woof";
    }
}
