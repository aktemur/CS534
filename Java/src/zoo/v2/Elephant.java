package zoo.v2;

public class Elephant extends Animal {
    public Elephant(String name, int color) {
        super(name, color);
    }

    public String sound() {
        return "woo";
    }
}
