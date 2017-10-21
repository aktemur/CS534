package bridge.v1;

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
