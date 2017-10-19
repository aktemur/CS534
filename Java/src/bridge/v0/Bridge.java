package bridge.v0;

abstract class Shape {
    Shape() {

    }

    abstract void draw();
}

abstract class Rectangle extends Shape {
    int x, y, w, h;

    Rectangle(int x, int y, int w, int h) {
        this.x = x; this.y = y; this.w = w; this.h = h;
    }
}

abstract class Circle extends Shape {
    int x, y, r;

    Circle(int x, int y, int r) {
        this.x = x; this.y = y; this.r = r;
    }
}

class WindowsRectangle extends Rectangle {
    WindowsRectangle(int x, int y, int w, int h) {
        super(x,y,w,h);
    }

    void draw() {
        // ...
    }
}

class WindowsCircle extends Circle {
    WindowsCircle(int x, int y, int r) {
        super(x,y,r);
    }

    void draw() {
        // ...
    }
}

class LinuxRectangle extends Rectangle {
    LinuxRectangle(int x, int y, int w, int h) {
        super(x,y,w,h);
    }

    void draw() {
        // ...
    }
}

class LinuxCircle extends Circle {
    LinuxCircle(int x, int y, int r) {
        super(x,y,r);
    }

    void draw() {
        // ...
    }
}

public class Bridge {
    public static void main(String[] args) {
        Shape circle = new LinuxCircle(100, 150, 20);
        Shape rect = new LinuxRectangle(40, 60, 70, 10);
        // Shape circle = new WindowsCircle(100, 150, 20);
        // Shape rect = new WindowsRectangle(40, 60, 70, 10);

        circle.draw();
        rect.draw();
    }
}
