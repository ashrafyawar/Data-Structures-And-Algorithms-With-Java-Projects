package Manipulation;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this class is used to read from file and create desired lists
 */
public class AuxiliaryClass {

    //data field
    private ArrayList<ArrayList<Integer>> visited;
    private int numV;
    private ListGraph listGraph;

    /**
     * constructor to create AuxiliaryClass
     */
    //construction field
    public AuxiliaryClass(){visited = new ArrayList<>(); numV = 0; }

    /**
     * this function reads graph info from a file
     * @return constructed ArrayList to the caller function
     */
    //methods field
    public ArrayList<ArrayList<Integer>>  readFromFile(){
        ArrayList<ArrayList<Integer>> maze = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File("/home/ashraf/Desktop/6.SEMESTER/(1)Data Structures (BİL 222)/HOMEWORKS/HW08/161044123_hw8/PART03/src/Manipulation/input"));
            while (scanner.hasNextLine()) {
                String s  = scanner.nextLine();
                String str[] = s.split(" ");
                ArrayList<Integer> temp = new ArrayList<>();
                for(int i = 0; i < str.length; i++) {
                    Integer t = Integer.parseInt(str[i]);
                    temp.add(t);
                    if (t == 0)
                        ++numV;
                }
                maze.add(temp);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        listGraph = new ListGraph(numV,true);
        System.out.println("listGraph with numV of: "+numV +" has been instantiated :)");
        return maze;
    }
    public ArrayList<ArrayList<Integer>> convert(ArrayList<ArrayList<Integer>> a){
        // no of vertices
        //int l = a[0].length;
        int l = a.size();
        ArrayList<ArrayList<Integer>> adjListArray = new ArrayList<>(l);

        // Create a new list for each
        // vertex such that adjacent
        // nodes can be stored
        for (int i = 0; i < l; i++) {
            adjListArray.add(new ArrayList<>());
        }
        int i, j;
        for (i = 0; i < a.get(0).size(); i++) {
            for (j = 0; j < a.size(); j++) {
                if (a.get(j).get(i) == 0) {
                    adjListArray.get(j).add(i);
                }
            }
        }
        return adjListArray;
    }
    // Function to print the adjacency list
    public void printArrayList(ArrayList<ArrayList<Integer>> adjListArray) {
        // Print the adjacency list
        for (int v = 0; v < adjListArray.size(); v++) {
            System.out.print(v);
            for (Integer u : adjListArray.get(v)) {
                System.out.print(" -> " + u);
            }
            System.out.println();
        }
    }

    public ArrayList<ArrayList<String>> constructGraph(@NotNull ArrayList<ArrayList<String>> list, int i, int j){
        if(i == list.size() && j == list.get(0).size()) {
            System.out.println("End of matrix...");
            return list;
        }
        else{

            ArrayList<Integer> vis = new ArrayList<>();
            vis.add(i);vis.add(j);
            visited.add(vis);//add visited edge to visited list.

            if (i - 1 >= 0 && !cont(i-1,j) && !list.get(i-1).get(j).equals("-2")){
                constructGraph(list,i-1,j);
            }
            if (i + 1 < list.size() && !cont(i+1,j) && !list.get(i+1).get(j).equals("-2")){
                constructGraph(list,i+1,j);
            }
            if (j - 1 >= 0 && !cont(i,j-1) && !list.get(i).get(j-1).equals("-2")){
                constructGraph(list,i,j-1);
            }
            if (j + 1 < list.get(0).size() && !cont(i,j+1) && !list.get(i).get(j+1).equals("-2")){
                constructGraph(list,i,j+1);
            }
        }
        return  list;
    }

    private boolean cont(int i,int j){
        for (int k = 0; k <visited.size() ; k++) {
            if (visited.get(k).get(0) == i && visited.get(k).get(1) == j)
                return true;
        }
        return false;
    }
    public void printMaze(@NotNull ArrayList<ArrayList<Integer>> maze){
        for (int i = 0; i <maze.size() ; i++) {
            for (int j = 0; j <maze.get(i).size() ; j++) {
                System.out.print(maze.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
    public int getNumV() {
        return numV;
    }
    public void setNumV(int numV) {
        this.numV = numV;
    }
}