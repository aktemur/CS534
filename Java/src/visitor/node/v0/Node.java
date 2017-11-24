package visitor.node.v0;

public abstract class Node {
    abstract int sum();
    abstract int max();
}

class Leaf extends Node {
    int value;

    Leaf(int value) {
        this.value = value;
    }

    int sum() {
        return value;
    }

    int max() {
        return value;
    }
}

class Binary extends Node {
    Node left;
    Node right;
    int value;
    
    Binary(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    int sum() {
        return value + left.sum() + right.sum();
    }

    int max() {
        return Math.max(Math.max(left.max(), right.max()), value);
    }

}

class Ternary extends Node {
    Node left;
    Node middle;
    Node right;

    Ternary(Node left, Node middle, Node right) {
        this.left = left;
        this.middle = middle;
        this.right = right;
    }

    int sum() {
        return left.sum() + middle.sum() + right.sum();
    }

    int max() {
        return Math.max(Math.max(left.max(), middle.max()), right.max());
    }
}
