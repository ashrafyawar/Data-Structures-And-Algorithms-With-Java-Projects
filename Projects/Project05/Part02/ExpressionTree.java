package part2Package;
import java.util.Scanner;

/**
 * Expression class extends BinaryTree class and adds more functionality to the class itself by adding more functions
 */
public class ExpressionTree extends BinaryTree {

    /**
     * this constructor takes a pre or postfix expression and constructs tree accordingly
     * first is assigns expression string to an array of string type and checks the first element by which we can find out
     * whether it is prefix expression of postfix expression by simply if first element of string array is an operator then it must
     * be a prefix expression otherwise postfix expression.
     * then calls their related wrapper functions relatively.
     * @param expression expression is the string which holds either prefix or postfix expression
     */
    public ExpressionTree(String expression) {

        String[] st = expression.split(" ");
        Scanner scan;

        if (isOperator(st[0])) {
            this.expressionType = "prefix";
            expression = expression+" "+"null";
            scan = new Scanner(expression);
        } else {

            this.expressionType = "postfix";
            String stTemp = "";
            for (int i = st.length - 1; i >= 0; i--) {
                stTemp = stTemp + st[i] + " ";
            }
            stTemp = stTemp+ " " +"null";
            scan = new Scanner(stTemp);
        }
        root = readBinaryTree(scan).root;
    }

    /**
     * this function check the type of expression whether prefix or postfix and calls related functions to evaluate particular expression.
     * @return returns the final result of prefix or postfix tree if exception returns -1
     */
    public int eval() {
        try {
            if (expressionType.equals("prefix")) {//if expression is prefix call evalPrefix function and return result as int
                return evalPrefix(root);
            } else {//else expression is postfix call evalPrefix function and return result as int
                return evalPostfix(root);
            }
        }catch (NullPointerException nl){
            System.out.println("Null pointer Exception !!!");
            return -1;
        }
    }
}