package bridge.v0;

abstract class Circle extends Shape {
    int x, y, r;

    Circle(int x, int y, int r) {
        this.x = x; this.y = y; this.r = r;
    }
}
