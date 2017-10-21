package bridge.v0;

public class Main {
    public static void main(String[] args) {
        Shape circle = new LinuxCircle(100, 150, 20);
        Shape rect = new LinuxRectangle(40, 60, 70, 10);
        // Shape circle = new WindowsCircle(100, 150, 20);
        // Shape rect = new WindowsRectangle(40, 60, 70, 10);

        circle.draw();
        rect.draw();
    }
}
