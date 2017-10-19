package zoo.v0;

public class Cat {
    private int color;
    private String name;

    public Cat(String name, int color) {
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
        return "meow";
    }
}
