import Manipulation.AuxiliaryClass;
import java.util.ArrayList;

/**
 * this class is used to test the whole program
 */
public class TestMain {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> maze;// pointer to maze Arraylist
        AuxiliaryClass auxiliaryClass = new AuxiliaryClass();// construct auxiliaryClass

        maze = auxiliaryClass.readFromFile();//read from file and instantiate listGraph with numV.
        auxiliaryClass.printMaze(maze);

        // function to convert adjacency
        // list to adjacency matrix
        ArrayList<ArrayList<Integer>> adjListArray = auxiliaryClass.convert(maze);
        System.out.println("Adjacency List: ");
       auxiliaryClass.printArrayList(adjListArray);

    }
}