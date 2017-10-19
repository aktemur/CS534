package bridge.v1;

abstract class Shape {
    ShapeImpl impl;

    Shape(ShapeImpl impl) {
        this.impl = impl;
    }

    abstract void draw();
}

class Rectangle extends Shape {
    int x, y, w, h;

    Rectangle(int x, int y, int w, int h, ShapeImpl impl) {
        super(impl);
        this.x = x; this.y = y; this.w = w; this.h = h;
    }

    void draw() {
        impl.draw_line(x, y, x+w, y);
        impl.draw_line(x+w, y, x+w, y+h);
        impl.draw_line(x+w, y+h, x, y+h);
        impl.draw_line(x, y+h, x, y);
    }
}

class Circle extends Shape {
    int x, y, r;

    Circle(int x, int y, int r, ShapeImpl impl) {
        super(impl);
        this.x = x; this.y = y; this.r = r;
    }

    void draw() {
        impl.draw_ellipse(x,y,2*r,2*r);
    }
}

abstract class ShapeImpl {
    abstract void draw_line(int x1, int y1, int x2, int y2);
    abstract void draw_ellipse(int x, int y, int w, int h);
}

class WindowsShapeImpl extends ShapeImpl {
    void draw_line(int x1, int y1, int x2, int y2) {
        // ...
    }
    void draw_ellipse(int x, int y, int w, int h) {
        // ...
    }
}

class LinuxShapeImpl extends ShapeImpl {
    void draw_line(int x1, int y1, int x2, int y2) {
    // ...
    }
    void draw_ellipse(int x, int y, int w, int h) {
        // ...
    }
}


public class Bridge {
    public static void main(String[] args) {
        //ShapeImpl impl = new WindowsShapeImpl();
        ShapeImpl impl = new LinuxShapeImpl();


        Shape circle = new Circle(100, 150, 20, impl);
        Shape rect = new Rectangle(40, 60, 70, 10, impl);

        circle.draw();
        rect.draw();
    }
}
