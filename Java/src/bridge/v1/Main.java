package bridge.v1;


public class Main {
    public static void main(String[] args) {
        //ShapeImpl impl = new WindowsShapeImpl();
        ShapeImpl impl = new LinuxShapeImpl();


        Shape circle = new Circle(100, 150, 20, impl);
        Shape rect = new Rectangle(40, 60, 70, 10, impl);

        circle.draw();
        rect.draw();
    }
}
