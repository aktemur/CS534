package bridge.v1;

abstract class Shape {
    ShapeImpl impl;

    Shape(ShapeImpl impl) {
        this.impl = impl;
    }

    abstract void draw();
}
