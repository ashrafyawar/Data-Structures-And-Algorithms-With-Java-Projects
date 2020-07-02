package part2Package;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Binary class particularly build to evaluate prefix and postfix expressions along with it's child class ExpressionTree class
 * @param <E> generic type class
 */
public class BinaryTree<E> implements Serializable {

    /**
     * Node class holds one element either operator or operand in this project.
     * @param <E> generic type Node class.
     */
    protected static class Node<E> implements Serializable {

        protected E data;
        protected Node<E> left;
        protected Node<E> right;

        public Node(E data) {
            this.data = data;
            left = null;
            right = null;
        }
        public String toString() {
            return data.toString();
        }
    }

    protected Node<E> root;
    protected static String expressionType = null;

    /**
     * Binary class default construction
     */
    public BinaryTree() { root = null; expressionType = null; }

    /**
     * Binary class construction.
     * @param root root of the tree
     */
    protected BinaryTree(Node<E> root) { this.root = root; }

    /**
     * Binary class construction
     * @param data data of generic type
     * @param leftTree reference to left child tree
     * @param rightTree reference to right child tree
     */
    public BinaryTree(E data, BinaryTree<E> leftTree,BinaryTree<E> rightTree) {
        root = new Node<E>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }

    /**
     * this functions is used to get the left subtree of a given root reference
     * @return returns left subtree if exists otherwise null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<E>(root.left);
        }
        else {
            return null;
        }
    }

    /**
     * this functions is used to get the right subtree of a given root reference
     * @return returns right subtree if exists otherwise null
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<E>(root.right);
        }
        else {
            return null;
        }
    }

    /**
     * this function takes a node reference and checks it's left and right child references
     * @param node node is reference to particular node
     * @return returns true if both left and right references are null otherwise false
     */
    public boolean isLeaf(Node node) { return (node.left == null && node.right == null); }

    /**
     * this function traverses tree in preorder manner and returns prefix tree expressions string representation.
     * @return string representation of a prefix expression tree.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, sb);
        return sb.toString();
    }

    /**
     * this function takes reference to a node and a String Builder element and traverses the tree and writes into string builder
     * @param node reference to the particular node
     * @param sb String Builder element
     */
    private void preOrderTraverse(Node<E> node,StringBuilder sb) {
        if (node == null) {
        } else {
            sb.append(" ");
            sb.append(node.toString());
            preOrderTraverse(node.left, sb);
            preOrderTraverse(node.right, sb);
        }
    }

    /**
     * this function traverses tree in post order manner and returns postfix tree expressions string representation.
     * @return string representation of a postfix expression tree.
     */
    public String toString1() {
        StringBuilder sb = new StringBuilder();
        postOrderTraverse(root,sb);
        return sb.toString();
    }

    /**
     * this function takes reference to a node and a String Builder element and traverses the in post order tree and writes into string builder
     * @param node reference to the particular node
     * @param sb String Builder element
     */
    private void postOrderTraverse(Node<E> node,StringBuilder sb) {
        if (node == null) {
        } else {
            postOrderTraverse(node.left, sb);
            postOrderTraverse(node.right, sb);
            sb.append(node.toString());
            sb.append(" ");
        }
    }

    /**
     * this function takes a Scanner class object which holds Expression to be constructed its tree
     * it checks whether the type of created expression class is prefix or postfix and calls its wrapper functions accordingly.
     * if prefix then call readAsPrefix() function elseif postfix then call readAsPostfix() function accordingly.
     * @param scan Scanner class object
     * @return returns a BinaryTree
     */
    public  BinaryTree<String> readBinaryTree(Scanner scan) {

        if(expressionType.equals("prefix")){
         return readAsPrefix(scan);
        }
        else if (expressionType.equals("postfix")){
            return readAsPostfix(scan);
        }
        else{
            System.out.println("WRONG EXPRESSION RETURNING NULL !!!");
            return  null;
        }
    }

    /**
     * this function takes a Scanner class Object and constructs a prefix expression tree
     * @param scan object of Scanner type holds expression
     * @return returns BinaryTree reference if successful null if not.
     */
    private BinaryTree<String> readAsPrefix(Scanner scan){

        String data = scan.next();
        if (data.equals("null")) {
            System.out.println("last null");
            return null;
        } else {
            if(isOperator(data)){
                BinaryTree<String> leftTree = readAsPrefix(scan);
                BinaryTree<String> rightTree = readAsPrefix(scan);
                return new BinaryTree<>(data, leftTree, rightTree);
            }else{
                return new BinaryTree<>(data, null, null);
            }
        }
    }

    /**
     * this function takes a Scanner class Object and constructs a postfix expression tree
     * @param scan object of Scanner type holds expression
     * @return returns BinaryTree reference if successful null if not.
     */
    private BinaryTree<String> readAsPostfix(Scanner scan){
        String data = scan.next();
        if (data.equals("null")) {
            System.out.println("last null");
            return null;
        } else {
            if(isOperator(data)){

                BinaryTree<String> rightTree = readAsPostfix(scan);
                BinaryTree<String> leftTree = readAsPostfix(scan);
                return new BinaryTree<>(data, leftTree, rightTree);
            }else{
                return new BinaryTree<>(data, null, null);
            }
        }
    }

    /**
     * this function takes root reference as input and evaluates prefix expression tree and reruns its final result as int
     * @param node reference to root node
     * @return returns result of prefix expressions final result if successful -1 otherwise
     */
    protected int evalPrefix(Node<E> node){

        int result = 0;
         if (isLeaf(node)){
             result = Integer.parseInt((String) node.data);
        }
        else{

            int firstNum  = evalPrefix(node.left);
            int secondNum = evalPrefix(node.right);
            if (node.data.equals("+"))
                result = firstNum + secondNum;
            else  if (node.data.equals("-"))
                result = firstNum - secondNum;
            else if (node.data.equals("*"))
                result = firstNum * secondNum;
            else if (node.data.equals("/"))
                result = firstNum / secondNum;
        }
        return result;
     }

     /**
     * this function takes root reference as input and evaluates postfix expression tree and reruns its final result as int
     * @param node reference to root node
     * @return returns result of postfix expressions final result if successful -1 otherwise
     */
    protected int evalPostfix(Node<E> node){

        int result = 0;
        if (isLeaf(node)){
            result = Integer.parseInt((String) node.data);
        }
        else{

            int secondNum = evalPostfix(node.right);
            int firstNum  = evalPostfix(node.left);

            if (node.data.equals("+"))
                result = firstNum + secondNum;
            else  if (node.data.equals("-"))
                result = firstNum - secondNum;
            else if (node.data.equals("*"))
                result = firstNum * secondNum;
            else if (node.data.equals("/"))
                result = firstNum / secondNum;
        }
        return result;
    }

    /**
     * this function takes a string and checks whether it is an operator or not and returns true if so otherwise returns false.
     * @param st st is string to be examined
     * @return returns true if the string is an operator otherwise returns false.
     */
    protected static boolean isOperator(String st){
        if (st.equals("+") || st.equals("-") || st.equals("*") ||st.equals("/") ){
            return true;
        }
        return false;
    }
}