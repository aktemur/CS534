package zoo.v3;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        zoo.add(new Animal("Felix", 123, Type.CAT));
        zoo.add(new Animal("Karabas", 99, Type.DOG));
        zoo.add(new Animal("Rocky", 256, Type.DOG));
        zoo.add(new Animal("Dumbo", 3, Type.ELEPHANT));
        zoo.add(new Animal("Pamuk", 456, Type.CAT));
        zoo.add(new Animal("Elmar", 5, Type.ELEPHANT));

        zoo.allSounds();
        zoo.allLegs();
    }
}