package Manipulation;

import java.io.BufferedReader;
import java.io.IOException;

/** Abstract base class for graphs. A graph is a set
*   of vertices and a set of edges. Vertices are
*   represented by integers from 0 to n - 1. Edges
*   are ordered pairs of vertices.
*   @author mohammad ashraf yawar
*/
public abstract class AbstractGraph implements Graph {

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
}