import java.util.Iterator;
import java.util.NoSuchElementException;

/** A MatrixGraph is an implementation of the Graph
*   abstract class that uses an array to represent the
*   edges.
*   @author Koffman and Wolfgang
*/

public class MatrixGraph
    extends AbstractGraph {

  /**** BEGIN EXERCISE ****/
  // Data field
  /** The two dimensional array to represen an edge */
  private double[][] edges;

  // Consructors
  /** Construct a graph with the specified number of
      vertices and directionality
      @param numV - The number of vertices
      @param directed - The directionality flag
   */
  public MatrixGraph(int numV, boolean directed) {
    super(numV, directed);
    edges = new double[numV][];
    if (!directed) {
      for (int i = 0; i != numV; ++i) {
        edges[i] = new double[numV];
        for (int j = 0; j != numV; ++j) {
          edges[i][j] = Double.POSITIVE_INFINITY;
        }
      }
    }
    else {
      for (int i = 0; i != numV; ++i) {
        edges[i] = new double[i + 1];
        for (int j = 0; j != i + 1; ++j) {
          edges[i][j] = Double.POSITIVE_INFINITY;
        }
      }
    }
  }

  // Implementation of abstract methods
  /** Insert a new edge into the graph
      @param edge - The new edge
   */
  public void insert(Edge edge) {
    setEdgeValue(edge.getSource(), edge.getDest(),
                 edge.getWeight());
  }

  @Override
  public void delete(Edge edge) {

  }

  /** Determine if an edge exists
      @param source - The source vertix
      @param dest - The destination vertix
      @return true if there is an edge from u to v
   */
  public boolean isEdge(int source, int dest) {
    return Double.POSITIVE_INFINITY != getEdgeValue(source, dest);
  }

  /** Get the edge between two vertices. If an
      edge does not exist, an Edge with a weight
      of POSITIVE_INFINITY is returned.
      @param source - The source
      @param dest - The destination
      @return the edge between these two vertices
   */
  public Edge getEdge(int source, int dest) {
    return new Edge(source, dest,
                    getEdgeValue(source, dest));
  }

  /** Return an iterator to the edges connected
      to a given vertix.
      @param source - The source vertix
      @return an EdgeIterator to the vertices
      contcted to source
   */
  public Iterator < Edge > edgeIterator(int source) {
    return new Iter(source);
  }

  @Override
  public void printGraph() {

  }

  /** Method to set the value of an edge
      @param source - The source vertix
      @param dest - The destination vertix
      @param wt - The weight
   */
  private void setEdgeValue(int source, int dest, double wt) {
    if (isDirected() || source <= dest) {
      edges[source][dest] = wt;
    }
    else {
      edges[dest][source] = wt;
    }
  }

  /** Method to get the value of an edge
   *  @param source - The source vertix
   *  @param dest - The destination vertix
   *  @return The weight of this edge or
   *  POSITIVE_INFINITY if no edge exists
   */
  private double getEdgeValue(int source, int dest) {
    if (isDirected() | source <= dest) {
      return edges[source][dest];
    }
    else {
      return edges[dest][source];
    }
  }

  // Iter class
  /** An iterator to the edges.  An Edge iterator is
   *  similar to an Iterator except that its
   *  next method will always return an edge
   */
  private class Iter
      implements Iterator < Edge > {
    // Data fields
    /** The source vertix for this iterator */
    private int source;

    /** The current index for this iterator */
    private int index;

    // Constructor
    /** Construct an EdgeIterator for a given vertix
     *  @param source - The source vertix
     */
    public Iter(int source) {
      this.source = source;
      index = -1;
      advanceIndex();
    }

    /** Return true if there are more edges
     *  @return true if there are more edges
     */
    public boolean hasNext() {
      return index != getNumV();
    }

    /** Return the next edge if there is one
     *  @throws NoSuchElementException - there are no
     *  more edges
     *  @return the next Edge in the iteration
     */
    public Edge next() {
      if (index == getNumV()) {
        throw new java.util.NoSuchElementException();
      }
      Edge returnValue = new Edge(source, index,
                                  getEdgeValue(source, index));
      advanceIndex();
      return returnValue;
    }

    /** Remove is not implemented
     *  @throws UnsupportedOperationExeption if called
     */
    public void remove() {
      throw new UnsupportedOperationException();
    }

    /** Advance the index to the next edge */
    private void advanceIndex() {
      do {
        index++;
      }
      while (index != getNumV()
             && Double.POSITIVE_INFINITY == getEdgeValue(source, index));
    }
  }

  /**** END EXERCISE ****/
}
