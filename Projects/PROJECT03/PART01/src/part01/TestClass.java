
package part01;

import java.util.List;
import java.util.ListIterator;

/**
 * this class contains main method in order to test the LinkedArrayList class and Node class
 */
public class TestClass {

    /**
     * @param args command line argment for main function
     */
    public static void main(String[] args) {

        //LinkedArrayList();
        List myObj = new LinkedArrayList();
        Node tem = null;

        System.out.println("Node index starts from 1 in this program >>>");
        System.out.println("*****************************************");

        //add(Object element);
        myObj.add(1);
        myObj.add(2);
        myObj.add(3);
        myObj.add(4);
        myObj.add(5);
        myObj.add(6);
        myObj.add(7);
        myObj.add(8);
        myObj.add(9);
        myObj.add(10);

        ((LinkedArrayList) myObj).displayElements();
        System.out.println();

        System.out.println("*****************************************");
        System.out.println("*****************************************");

        //add(int index,Object element);
        myObj.add(2,1000);
        ((LinkedArrayList) myObj).displayElements();
        System.out.println();

        System.out.println("*****************************************");
        System.out.println("*****************************************");

        // get(index)
        System.out.println("Get method Usage ....");
        System.out.println(myObj.get(0));
        System.out.println(myObj.get(8));
        System.out.println(myObj.get(11));


        System.out.println("*****************************************");
        System.out.println("*****************************************");
        System.out.println("Calling Remove function...");

        //remove(Integer element)
        myObj.remove(0);
        ((LinkedArrayList) myObj).displayElements();
        System.out.println();

        myObj.remove(0);
        ((LinkedArrayList) myObj).displayElements();
        System.out.println();

        myObj.remove(0);
        ((LinkedArrayList) myObj).displayElements();
        System.out.println();


        System.out.println();

        System.out.println("*****************************************");
        System.out.println("*****************************************");

        //size()
        System.out.println("Current LinkedArrayList Size :"+myObj.size());

        System.out.println("*****************************************");
        System.out.println("*****************************************");

        //iterator >>>

        System.out.println("*****************************************");
        System.out.println("*****************************************");
        System.out.println("ITERATOR PART TEST CASES...");

        ListIterator iterator = myObj.listIterator();
        System.out.println(iterator.hasNext());

        System.out.println(((LinkedArrayList) myObj).next());
        System.out.println(((LinkedArrayList) myObj).next());
        System.out.println(((LinkedArrayList) myObj).next());

    }
}
