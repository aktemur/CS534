package zoo.v3;

enum Type {
    CAT, DOG, ELEPHANT, CHICKEN
}

public class Animal {
    private Type type;
    private int color;
    private String name;

    public Animal(String name, int color, Type type) {
        this.name = name;
        this.color = color;
        this.type = type;
    }

    public int color() {
        return color;
    }

    public String name() {
        return name;
    }

    public int numLegs() {
        if (type == Type.CHICKEN)
            return 2;
        return 4;
    }

    public String sound() {
        switch(type) {
            case CAT:
                return "meow";
            case DOG:
                return "woof";
            case ELEPHANT:
                return "woo";
            case CHICKEN:
                return "gitgit";
            default:
                throw new Error();
        }
    }

    public void walk() {
        switch(type) {
            case CAT:
                System.out.println("cat walk");
                break;
            case DOG:
                System.out.println("dog walk");
                break;
            case ELEPHANT:
                System.out.println("elephant walk");
                break;
            case CHICKEN:
                System.out.println("chicken walk");
                break;
        }
    }
}












