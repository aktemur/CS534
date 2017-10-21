package bridge.v1;

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
