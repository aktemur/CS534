package visitor.v1;

public abstract class Node {
    abstract void accept(Visitor v);
}

class Leaf extends Node {
    int value;

    Leaf(int value) {
        this.value = value;
    }

    void accept(Visitor v) {
        v.visitLeaf(this);
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

    void accept(Visitor v) {
        v.visitBinary(this);
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

    void accept(Visitor v){
        v.visitTernary(this);
    }
}
