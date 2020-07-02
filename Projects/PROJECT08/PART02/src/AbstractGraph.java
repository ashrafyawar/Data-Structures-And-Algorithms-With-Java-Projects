import java.io.BufferedReader;
import java.io.IOException;

/** Abstract base class for graphs. A graph is a set
*   of vertices and a set of edges. Vertices are
*   represented by integers from 0 to n - 1. Edges
*   are ordered pairs of vertices.
*   @author mohammad ashraf yawar
*/
public abstract class AbstractGraph implements Graph{

  // Data Fields
  /** The number of vertices */
  private int numV;

  /** Flag to indicate whether this is a directed graph */
  private boolean directed;

  // Constructor
  /** Construct a graph with the specified number of vertices
      and the directed flag. If the directed flag is true,
      this is a directed graph.
      @param numV The number of vertices
      @param directed The directed flag
   */
  public AbstractGraph(int numV, boolean directed) {
    this.numV = numV;
    this.directed = directed;
  }

  // Accessor Methods
  /** Return the number of vertices.
      @return The number of vertices
   */
  public int getNumV() {
    return numV;
  }
  public void setNumV(int value){numV = value;}

  /** Return whether this is a directed graph.
      @return true if this is a directed graph
   */
  public boolean isDirected() {
    return directed;
  }

  // Other Methods
  /** Load the edges of a graph from the data in an input file.
      The file should contain a series of lines, each line
      with two or three data values. The first is the source,
      the second is the destination, and the optional third
      is the weight.
      @param bR The buffered reader containing the data
      @throws IOException if an I/O error occurs
   */
  public void loadEdgesFromFile(BufferedReader bR) throws IOException {
    // Programming Exercise 1
  }

  /** Factory method to create a graph and load the data from an input
      file. The first line of the input file should contain the number
      of vertices. The remaining lines should contain the edge data as
      described under loadEdgesFromFile.
      @param bR The BufferedReader that is connected to
                            the file that contains the data
      @param isDirected true if this is a directed graph,
                        false otherwise
      @param type The string "Matrix" if an adjacency matrix is to be
                  created, and the string "List" if an adjacency list
                  is to be created of LinkedListGraph
      @throws IOException if there is an I/O error
      @throws IllegalArgumentException if type is neither "Matrix" nor "List"
   */
  public static Graph createGraph(BufferedReader bR,boolean isDirected,String type) throws IOException {

      String line = bR.readLine();
      int numV = Integer.parseInt(line);
      AbstractGraph returnValue = null;
      if (type.equalsIgnoreCase("Matrix"))
        returnValue = new MatrixGraph(numV, isDirected);
      else if (type.equalsIgnoreCase("List"))
        returnValue = new ListGraph(numV, isDirected);
      else if(type.equalsIgnoreCase("LinkedList"))
          returnValue = new LinkedListGraph(numV,isDirected);
      else
        throw new IllegalArgumentException();
      returnValue.loadEdgesFromFile(bR);
      return returnValue;
  }
}