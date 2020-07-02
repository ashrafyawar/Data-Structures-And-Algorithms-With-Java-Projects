import java.util.*;
import java.io.*;

/** A ListGraph is an extension of the AbstractGraph abstract class
*   that uses an array of lists to represent the edges.
*   @author Koffman and Wolfgang
*/

public class ListGraph extends AbstractGraph {

  // Data Field
  /** An array of Lists to contain the edges that
      originate with each vertex. */
  private List < Edge > [] edges;

  /** Construct a graph with the specified number of
      vertices and directionality.
      @param numV The number of vertices
      @param directed The directionality flag
   */
  public ListGraph(int numV, boolean directed) {
    super(numV, directed);
    edges = new List[numV];
    for (int i = 0; i < numV; i++) {
      edges[i] = new LinkedList < Edge > ();
    }
  }

  /** Determine whether an edge exists.
      @param source The source vertex
      @param dest The destination vertex
      @return true if there is an edge from source to dest
   */
  public boolean isEdge(int source, int dest) {
    return edges[source].contains(new Edge(source, dest));
  }

  /** Insert a new edge into the graph.
      @param edge The new edge
   */
  public void insert(Edge edge) {
    edges[edge.getSource()].add(edge);
    if (!isDirected()) {
      edges[edge.getDest()].add(new Edge(edge.getDest(),
                                         edge.getSource(),
                                         edge.getWeight()));
    }
  }

  @Override
  public void delete(Edge edge) {

  }


  public Iterator < Edge > edgeIterator(int source) {
    return edges[source].iterator();
  }

  @Override
  public void printGraph() {

  }

  /** Get the edge between two vertices. If an
      edge does not exist, an Edge with a weight
      of Double.POSITIVE_INFINITY is returned.
      @param source The source
      @param dest The destination
      @return the edge between these two vertices
   */
  public Edge getEdge(int source, int dest) {
    Edge target =
        new Edge(source, dest, Double.POSITIVE_INFINITY);
    for (Edge edge : edges[source]) {
      if (edge.equals(target))
        return edge; // Desired edge found, return it.
    }
    // Assert: All edges for source checked.
    return target; // Desired edge not found.
  }

  /** Load the edges of a graph from the data in an input file.
        The file should contain a series of lines, each line
        with two or three data values. The first is the source
        the second is the destination, and the optional third
        is the weight
        @param bufferedReader The BufferedReader that is connected
                              to the file that contains the data
        @throws IOException - If an I/O error occurs
   */
  public void loadEdgesFromFile(BufferedReader bufferedReader) throws
      IOException {
    /**** BEGIN EXERCISE ****/
    String line;
    while ( (line = bufferedReader.readLine()) != null
           && line.length() != 0) {
      Scanner sc = new Scanner(line);
      int source = sc.nextInt();
      int dest = sc.nextInt();
      double weight = 1.0;
      if (sc.hasNextDouble())
        weight = sc.nextDouble();
      insert(new Edge(source, dest, weight));
    }
    /**** END EXERCISE ****/
  }

}
