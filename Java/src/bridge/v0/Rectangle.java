package bridge.v0;

abstract class Rectangle extends Shape {
    int x, y, w, h;

    Rectangle(int x, int y, int w, int h) {
        this.x = x; this.y = y; this.w = w; this.h = h;
    }
}
