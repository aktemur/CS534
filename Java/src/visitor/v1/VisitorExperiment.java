package visitor.v1;

public class VisitorExperiment {
    public static void main(String[] args) {
        Node root = new Binary(12,
                               new Ternary(new Leaf(15),
                                           new Binary(9,
                                                      new Leaf(7),
                                                      new Leaf(25)),
                                           new Leaf(34)),
                               new Binary(2,
                                          new Leaf(13),
                                          new Leaf(4)));
        SumVisitor sv = new SumVisitor();
        sv.visit(root);
        int sum = sv.sum;
        System.out.println("Sum: " + sum);

        MaxVisitor mv = new MaxVisitor();
        mv.visit(root);
        int max = mv.max;
        System.out.println("Sum: " + max);

        PreOrderPrinter pop = new PreOrderPrinter();
        pop.visit(root);
        System.out.println();
        
        ReversePostOrderPrinter rpop = new ReversePostOrderPrinter();
        rpop.visit(root);
        System.out.println();
    }
}

