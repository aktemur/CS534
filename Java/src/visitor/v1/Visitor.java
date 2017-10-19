package visitor.v1;

public abstract class Visitor {
    void visit(Node n) {
        n.accept(this);
    }
    
    abstract void visitLeaf(Leaf leaf);
    
    abstract void visitBinary(Binary binary);
    
    abstract void visitTernary(Ternary ternary);
}

abstract class PreOrderVisitor extends Visitor {
    void visitLeaf(Leaf leaf) {
        processLeafValue(leaf.value);
    }

    void visitBinary(Binary binary) {
        processBinaryValue(binary.value);
        visit(binary.left);
        visit(binary.right);
    }

    void visitTernary(Ternary ternary) {
        visit(ternary.left);
        visit(ternary.middle);
        visit(ternary.right);
    }

    abstract void processLeafValue(int value);

    abstract void processBinaryValue(int value);
}

abstract class ReversePostOrderVisitor extends Visitor {
    void visitLeaf(Leaf leaf) {
        processLeafValue(leaf.value);
    }

    void visitBinary(Binary binary) {
        visit(binary.right);
        visit(binary.left);
        processBinaryValue(binary.value);
    }

    void visitTernary(Ternary ternary) {
        visit(ternary.right);
        visit(ternary.middle);
        visit(ternary.left);
    }

    abstract void processLeafValue(int value);

    abstract void processBinaryValue(int value);
}

class SumVisitor extends PreOrderVisitor {
    int sum = 0;
    
    void processLeafValue(int value) {
        sum += value;
    }
    
    void processBinaryValue(int value) {
        sum += value;
    }
}

class MaxVisitor extends PreOrderVisitor {
    int max = Integer.MIN_VALUE;

    void processLeafValue(int value) {
        max = Math.max(max, value);
    }

    void processBinaryValue(int value) {
        max = Math.max(max, value);
    }
}

class PreOrderPrinter extends PreOrderVisitor {
    void processLeafValue(int value) {
        System.out.print(value + " ");
    }

    void processBinaryValue(int value) {
        System.out.print(value + " ");
    }
}

class ReversePostOrderPrinter extends ReversePostOrderVisitor {
    void processLeafValue(int value) {
        System.out.print(value + " ");
    }

    void processBinaryValue(int value) {
        System.out.print(value + " ");
    }
}
