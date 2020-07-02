package part2Package;

public class TestMain {
    public static void main(String[] args) {

        System.out.println("prefix expression ...");
        ExpressionTree expTree = new ExpressionTree("+ + 10 * 5 15 20");
        System.out.println(expTree.toString());
        int result = expTree.eval();
        System.out.println("Solution is :" + result);

        System.out.println("prefix expression ...");
        ExpressionTree expTree1 = new ExpressionTree("- + * 1 2 * 3 4 + - 5 6 / 7 8");
        System.out.println(expTree1.toString());
        int result1 = expTree1.eval();
        System.out.println("Solution is :" + result1);

        System.out.println("postfix expression ...");
        ExpressionTree expTree2 = new ExpressionTree("10 5 15 * + 20 +");
       System.out.println(expTree2.toString1());
        int result2 = expTree2.eval();
        System.out.println("Solution is :" + result2);

        System.out.println("postfix expression ...");
        ExpressionTree expTree3 = new ExpressionTree("1 2 * 3 4 * + 5 6 - 7 8 / + -");
        System.out.println(expTree3.toString1());
        int result3 = expTree3.eval();
        System.out.println("Solution is :" + result3);
    }
}
