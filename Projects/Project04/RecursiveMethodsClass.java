package RecursiveMethodsPackage;

import java.util.Deque;
import java.util.LinkedList;

public class RecursiveMethodsClass {

    /**
     * this function reverses a given string using recursion
     *
     * @param st st is string to be reversed
     * @return returns the reversed string.
     */
    public String reverse(String st) {

        int space = st.indexOf(" ");//find indexof first occurence of space on the string

        if (space != -1) {// if space
            reverse(st.substring(space + 1));//calls function itself with new string
        }
        if (space == -1) {//base case
            st = " " + st;
        } else {
            System.out.print(" " + st.substring(0, space));
        }
        return st;//return space
    }

    /**
     * this function finds lettrs e l and f in exist using recursion in a given string and returns true if found otherwise false.
     *
     * @param st string in which we check the characters e l and f
     * @return true if exist false otherwise
     */
    public boolean findELF(String st) {

        if (st.isEmpty()) {//if we are at the end of string
            return false;
        }
        if (st.contains("e") && st.contains("l") && st.contains("f")) {//if there exist letters e l and f in string
            return true;
        } else {
            return findELF(st.substring(1));//call recursively with new start index
        }
    }

    /**
     * this function find the index of minimum element in a given array using recursion.
     *
     * @param charArray character array
     * @param index     starting index of charArray
     * @param lenght    lenght of the charArray
     * @return returns index of minimum element in charArray
     */
    public static int minimumIndex(char charArray[], int index, int lenght) {

        int minIndex;
        if (index == lenght) {//base case if we reach end of chaArray.
            return index;
        }
        minIndex = minimumIndex(charArray, index + 1, lenght);//find index of minimum element in the charArray.

        if (charArray[index] < charArray[minIndex]) {//if the current char is smaller than the minimum char in the Array the return index
            return index;
        } else {
            return minIndex;//else offsite
        }
    }

    /**
     * this function sorts given array using selection sort and recursion
     *
     * @param charArray character array
     * @param lenght    size of charArray
     * @param index     index of current position
     */
    public static void recursiveSelectionSort(char charArray[], int lenght, int index) {

        int minIndex;
        if (index == lenght) {//base case
            return;
        }
        minIndex = minimumIndex(charArray, index, lenght - 1);//find index of minimum element in the charArray

        if (minIndex != index) {
            // swap
            char temp = charArray[minIndex];
            charArray[minIndex] = charArray[index];
            charArray[index] = temp;
        }
        recursiveSelectionSort(charArray, lenght, index + 1);//call function itself recursively
    }

    /**
     * this function takes an expression and decides whether it is postfix or prefix by using string st
     * and evaluates the expression.
     *
     * @param input expression to be evaluated
     * @param st    string which either postfix or prefix
     * @return returns the solved expression as double.
     */
    public static double evaluateExpression(Deque<String> input, String st) {

        if (input.element() != null && input.element().matches("^(-?)\\d+$")) {//base case if we reach end of string or we catch a number(using regex)
            return Long.parseLong(input.removeFirst());
        } else {

            double result = 0, leftOperand = 0, rightOperand = 0;
            String operator = null;

            if (st.equals("pref")) {//if expression is prefix

                operator = input.removeFirst();//get operator
                leftOperand = evaluateExpression(input, st);//get left operand by calling itself
                rightOperand = evaluateExpression(input, st);//get right operand by calling itself

            } else if (st.equals("post")) {//if expression is postfix

                operator = input.removeFirst();//get the operator
                rightOperand = evaluateExpression(input, st);//get right operand by calling itself
                leftOperand = evaluateExpression(input, st);//get left operand by calling itself
            }

            switch (operator) {//solve according to operator
                case "+":
                    result = (leftOperand + rightOperand);
                    break;
                case "-":
                    result = leftOperand - rightOperand;
                    break;
                case "*":
                    result = leftOperand * rightOperand;
                    break;
                case "/":
                    result = leftOperand / rightOperand;
                    break;
                default:
                    System.out.println("Cant not solve Wrong input !!!!");
            }
            return result;
        }
    }

    /**
     * this function calls a helper function to evaluate the given expression and returns the value to the caller.
     *
     * @param input expression to be evaluated
     * @param st    expression type indicator (whether postfix or prefix) in this case prefix
     * @return returns the result
     */
    public static double prefixEvaluation(Deque<String> input, String st) {
        return evaluateExpression(input, st);
    }

    /**
     * this function takes an expression in postfix form and calls a helper function to evaluate it
     *
     * @param input expression to be evaluated.
     * @param st    expression type indicator (whether postfix of prefix ) in this case postfix
     * @return the final result of expression as double.
     */
    public static double postfixEvaluation(Deque<String> input, String st) {

        Deque<String> temp = new LinkedList<>();
        for (String element : input) {
            temp.addFirst(element);
        }//copy all the elements in reverse order.
        return prefixEvaluation(temp, st);
    }

    /**
     * this function takes a 2D array and it's corrrsponding row colunms indexes and lenghts and prints it's
     * content in spiral order or form using recursion.
     * @param array is the 2D array to be printed
     * @param rowIndex is the row index
     * @param rowSize is the row size
     * @param colIndex is the column index
     * @param colSize is the columns size
     */
     public void print2DArray(int[][] array, int rowIndex, int rowSize, int colIndex, int colSize) {//reference of this function is partially taken from some resourse
                                                                                                // and its better to mention it .
        for (int i = rowIndex; i < colSize; i++)
            System.out.print(array[rowIndex][i] + " ");

        for (int i = rowIndex + 1; i < rowSize; i++)
            System.out.print(array[i][colSize - 1] + " ");

        if (rowIndex + 1 < rowSize) {
            int idx = colSize - 2;
            for (int k = idx; k >= colIndex; k--)
                System.out.print(array[rowSize - 1][k] + " ");
        }

        if (colIndex + 1 < colSize) {
            int idx = rowSize - 2;
            for (int k = idx; k > rowIndex; k--)
                System.out.print( array[k][colIndex] + " ");
        }

        // recursion
        if (rowIndex < rowSize && colIndex < colSize) {
            print2DArray(array, rowIndex + 1, rowSize - 1, colIndex + 1, colSize - 1);
        }
    }
}