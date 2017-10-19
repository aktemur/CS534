package zoo.v2;

public abstract class Animal {
    private int color;
    private String name;

    public Animal(String name, int color) {
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

    public abstract String sound();
}
