package zoo.v2;

public class Cat extends Animal {
    public Cat(String name, int color) {
        super(name, color);
    }

    public String sound() {
        return "meow";
    }
}
