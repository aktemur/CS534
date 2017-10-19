package zoo.v1;

public class Elephant implements Animal {
    private int color;
    private String name;

    public Elephant(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public int color() {
        return color;
    }

    public String name() {
        return name;
    }

    public int numLegs() {
        return 4;
    }

    public String sound() {
        return "woo";
    }
}
