package zoo.v2;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.add(new Cat("Felix", 123));
        zoo.add(new Dog("Karabas", 99));
        zoo.add(new Dog("Rocky", 256));
        zoo.add(new Elephant("Dumbo", 3));
        zoo.add(new Cat("Pamuk", 456));
        zoo.add(new Elephant("Elmar", 5));

        zoo.allSounds();
        zoo.allLegs();
    }
}