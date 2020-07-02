package RecursiveMethodsPackage;

import java.util.Deque;
import java.util.LinkedList;

public class MainClass {

    public static void main(String[] args) {

        RecursiveMethodsClass recObj = new RecursiveMethodsClass();
        System.out.println();
        System.out.println(" **** Test Class **** ");

        //reverseString()
        System.out.println("reverseString() Testing... ");
        System.out.println("Original String : 'Hi This Is Third Part Of HomeWork 04'");
        System.out.println("Calling reverseString With Above String...");
        recObj.reverse("Hi This Is Third Part Of HomeWork 04 ");

        System.out.println();
        System.out.println();
        System.out.println("findELF() Testing...");
        System.out.println(recObj.findELF("whiteleaf"));
        System.out.println(recObj.findELF("tasteful"));
        System.out.println(recObj.findELF("unfriendly"));
        System.out.println(recObj.findELF("waffles"));
        System.out.println(recObj.findELF("ttt"));

        System.out.println();
        //recursiveSelectionSort()
        char charArray[] = new char[]{'d', 'r', 'a', 'c', 'b'};
        System.out.println("recursiveSelectionSort() Testing...");
        System.out.print("Before Sorting >>>  [ ");

        for (int i:charArray) {
            System.out.print((char) i+" ");
        }
        System.out.println(" ]");

        recObj.recursiveSelectionSort(charArray,charArray.length,0);

        System.out.print("After Sorting >>>  [ ");
        for (int i:charArray) {
            System.out.print((char) i+" ");
        }
        System.out.println(" ]");

        //prefixEvaluation()
        System.out.println();
        System.out.println();
        System.out.println("prefixEvaluation() Testing...");

        String input = "- + + 1 / - 2 * 4 6 2 1 / 1 4";
        String[] ex = input.split ( " " );

        Deque<String> lastEx = new LinkedList<String>();
        for (String element : ex) { lastEx.addLast(element); }
        System.out.println("Expression is : " + lastEx);

        System.out.println("value of Above Expression  = " + recObj.prefixEvaluation(lastEx,"pref"));
        System.out.println();

        //postfixEvaluation()
        System.out.println("postfixEvaluation() Testing...");

        String newinput = "1 2 4 6 * - 2 / + 1 + 1 4 / -";
        String[] exe = newinput.split ( " " );

        Deque<String> Ex = new LinkedList();
        for (String element : exe) { Ex.addLast(element); }
        System.out.println("Expression is : " + Ex);

        System.out.println("value of Above Expression  = " + recObj.postfixEvaluation(Ex,"post"));
        System.out.println();

        //recursivePrintArray()
        System.out.println("recursivePrintArray() Testing...");
        int array[][] = new int [5][4];

        array[0][0] = 1;array[0][1] = 2;array[0][2] = 3;array[0][3] = 4;
        array[1][0] = 5;array[1][1] = 6;array[1][2] = 7;array[1][3] = 8;
        array[2][0] = 9;array[2][1] = 10;array[2][2] = 11;array[2][3] = 12;
        array[3][0] = 13;array[3][1] = 14;array[3][2] = 15;array[3][3] = 16;
        array[4][0] = 17;array[4][1] = 18;array[4][2] = 19;array[4][3] = 20;

        System.out.println("Input is :");
        for (int i = 0; i <array.length; i++) {
            for (int j = 0; j <array[i].length ; j++){ System.out.print(" "+array[i][j]); }
            System.out.println();
        }

        System.out.print("Output : ");
        recObj.print2DArray(array,0,array.length,0,array[0].length);
        System.out.println();
    }
}