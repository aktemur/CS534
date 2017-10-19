package zoo.v1;

public class Dog implements Animal {
    private int color;
    private String name;

    public Dog(String name, int color) {
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
        return "woof";
    }
}
