import org.jetbrains.annotations.NotNull;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;

/** A LinkedListGraph is an extension of the AbstractGraph abstract class
 *   that uses an 2D LinkedList to represent the edges.
 *   @author mohammad ashraf yawar
 */

public class LinkedListGraph extends AbstractGraph {

    /**
     * Node class keeps edge as it's data and references to a nodes 4 direction to be accessible
     */
     class Node{

        Edge edge;
        Node rPrev;
        Node rNext;
        Node cPrev;
        Node cNext;

        /**
         * Node class default constructor.
         */
        Node(){rPrev = rNext = cPrev = cNext = null;}

        /**
         * this Node constructor created automatically when creating the object of Node type.
         * this node created an arrayList of size CAPACITY and assigns the E element at index size.
         * @param source type int
         * @param destination type int
         */
        Node(int source,int destination){
            edge = new Edge(source,destination);
        }
    }

    // Data Field
    /** A node for row and columns  to contain the edges that
     originate with each vertex. */
    private Node rNodeHead;
    private Node cNodeHead;
    private MyIterator it;

    /** Construct a graph with the specified number of
     vertices and directionality.
     @param numV The number of vertices
     @param directed The directionality flag
     */
    public LinkedListGraph(int numV, boolean directed) {

        super(numV, directed);//stores the  number of elements and is directed status on super class (AbstractGraph.java)

        rNodeHead = new Node(0,0);
        cNodeHead = new Node(0,0);
        Node rtemp = rNodeHead;
        Node ctemp = cNodeHead;

       if(directed){//if directed graph

           for (int i = 1; i < numV; i++) {
               rtemp.rNext = new Node(i,0);
               ctemp.cNext = new Node(0,i);
               rtemp = rtemp.rNext;
               ctemp = ctemp.cNext;
           }
       }
       else{//if undirected graph
           for (int i = 1; i < numV; i++) {

               Node r = new Node(i,0);
               Node c = new Node(0,i);

               r.rPrev = rtemp;
               rtemp.rNext = r;

               c.cPrev = ctemp;
               ctemp.cNext = c;

               rtemp = rtemp.rNext;
               ctemp = ctemp.cNext;
           }
       }
    }

    /**
     * @param value number of edges in a graph
     */
    @Override
    public void setNumV(int value) {
        super.setNumV(value);
    }

    /** Insert a new edge into the graph.
     * this function takes an edge object creates corresponding node object and the adds according to graph type
     @param edge The new edge
     */
    public void insert(@NotNull Edge edge) {

        if (getNumV() < edge.getSource() || getNumV() < edge.getDest()){//if user inters out of bound indexes to insert an edge.
            System.out.println("Ops out of bound indexes !!!!");
            return;
        }
        if(isDirected()){//bounding new node into its corresponding row and column nodes.

            Node newNode = new Node();//create new node
            Node rNode = rNodeHead;
            Node cNode = cNodeHead;
            newNode.edge = edge;

            for (int i = 0; i < newNode.edge.getSource(); i++) //set pointer in row to add new edge
                rNode = rNode.rNext;
            for (int i = 0; i < newNode.edge.getDest(); i++) //set pointer in column to add new edge
                cNode = cNode.cNext;

            while (rNode.cNext != null){//reach the end of particular edge adjacent vertex.
                rNode = rNode.cNext;
            }
            while (cNode.rNext != null){//reach the end of particular edge adjacent vertex.
                cNode = cNode.rNext;
            }
            rNode.cNext = newNode;//bound new edge to the graph
            cNode.rNext = newNode;

        }else{

            Node newNode = new Node();//create new node
            Node rNode = rNodeHead;
            Node cNode = cNodeHead;
            newNode.edge = edge;

            for (int i = 0; i < newNode.edge.getSource(); i++)  //set pointer in row to add new edge
                rNode = rNode.rNext;
            for (int i = 0; i < newNode.edge.getDest(); i++) //set pointer in column to add new edge
                cNode = cNode.cNext;

            while (rNode.cNext != null){
                rNode = rNode.cNext;
            }
            while (cNode.rNext != null){
                cNode = cNode.rNext;
            }

            newNode.cPrev = rNode;
            rNode.cNext = newNode;
            newNode.rPrev = cNode;
            cNode.rNext = newNode;

            Node newNode1 = new Node();//create new node
            Edge newEdge = new Edge(edge.getDest(),edge.getSource());
            rNode = rNodeHead;
            cNode = cNodeHead;
            newNode1.edge = newEdge;

            for (int i = 0; i < newNode1.edge.getSource(); i++) //get index of source node
                rNode = rNode.rNext;
            for (int i = 0; i < newNode1.edge.getDest(); i++) // get index of dest node.
                cNode = cNode.cNext;

            boolean containsEdge = false;
            while (rNode.cNext != null){//reach the end of particular edge adjacent vertex.
                if (rNode.cNext.edge.getDest() == newNode1.edge.getDest()){
                    containsEdge = true;
                    break;
                }
                rNode = rNode.cNext;
            }
            while (cNode.rNext != null){//reach the end of particular edge adjacent vertex.
                if (cNode.rNext.edge.getDest() == newNode1.edge.getDest()){
                    containsEdge = true;
                    break;
                }
                cNode = cNode.rNext;
            }
            
            if (!containsEdge){//if new edge is not already in the graph.
                newNode1.cPrev = rNode;//bound new edge to the graph
                rNode.cNext = newNode1;//bound new edge to the graph
                newNode1.rPrev = cNode;//bound new edge to the graph
                cNode.rNext = newNode1;//bound new edge to the graph
            }
        }
    }

    /**
     * this method deleted given edge from graph according to graph's type (directed or undirected).
     * @param edge edge to be deleted from graph
     */
    public void delete(@NotNull Edge edge){

        if (getNumV() < edge.getSource() || getNumV() < edge.getDest()){//if user inters out of bound indexes to insert an edge.
            System.out.println("Ops out of bound indexes !!!!");
            return;
        }

        if(isDirected()){//if directed graph

            Node newNode = new Node();//create new node
            Node rNode = rNodeHead;
            Node cNode = cNodeHead;
            newNode.edge = edge;
            boolean found1 = false,found2 = false;

            for (int i = 0; i < newNode.edge.getSource(); i++) //set pointer in row to add new edge
                rNode = rNode.rNext;
            for (int i = 0; i < newNode.edge.getDest(); i++) //set pointer in column to add new edge
                cNode = cNode.cNext;

            while (rNode.cNext != null){//find position one before the edge to unbound in row order
                if (rNode.cNext.edge.getSource() == newNode.edge.getSource() && rNode.cNext.edge.getDest() == newNode.edge.getDest()){
                    found1 = true;
                    break;
                }
                rNode = rNode.cNext;
            }
            while (cNode.rNext != null){//find position one before the edge to unbound in column order
                if (cNode.rNext.edge.getSource() == newNode.edge.getSource() && cNode.rNext.edge.getDest() == newNode.edge.getDest()){
                    found2 = true;
                    break;
                }
                cNode = cNode.rNext;
            }

            if (!found1 && !found2){//if not found return
                System.out.println("could not find !!!  :(((");
                return;
            }
            rNode.cNext = rNode.cNext.cNext;//unbound the edge
            cNode.rNext = cNode.rNext.rNext;//unbound the edge
        }
        else{//if undirected graph
            Node newNode = new Node();//create new node
            Node rNode = rNodeHead;
            newNode.edge = edge;

            for (int i = 0; i < newNode.edge.getSource(); i++) //get index of source node
                rNode = rNode.rNext;

            boolean found = false; // used to indicated whether we found the edge to delete or not
            rNode = rNode.cNext;
            while (rNode.cNext != null){
                if (rNode.edge.getSource() == newNode.edge.getSource() && rNode.edge.getDest() == newNode.edge.getDest()){
                    found = true;
                    break;
                }
                rNode = rNode.cNext;
            }
            if (!found) {
                System.out.println("could not find !!!  :(((");
                return;
            }

            if (rNode.cNext == null){
                rNode.cPrev.cNext = null;
            }else{
                rNode.cPrev.cNext = rNode.cNext;
                rNode.cNext.cPrev = rNode.cPrev;
            }

            if (rNode.rNext == null) {
                rNode.rPrev.rNext = null;
            }
            else{
                rNode.rPrev.rNext = rNode.rNext;
                rNode.rNext.rPrev = rNode.rPrev;
            }
            }
    }

    /**
     * inserts a vertex in row and column order to be linked later
     */
    public void insertVertex(){

       Node rNode = rNodeHead;
       Node cNode = cNodeHead;

        while (rNode.rNext != null && cNode.cNext != null){
            rNode = rNode.rNext;
            cNode = cNode.cNext;
        }
        if (isDirected()) {
            rNode.rNext = new Node();
            cNode.cNext = new Node();
        }
        else{
            rNode.rNext = new Node();
            rNode.rNext.rPrev  = rNode;
            cNode.cNext = new Node();
            cNode.cNext.cPrev = cNode;
        }
        setNumV(getNumV()+1);
    }

    /**
     * this function takes a vertex to be deleted from graph and unbound's it from graph
     * @param vertex vertex to be deleted
     */
    public void deleteVertex(int vertex){

        if(vertex > getNumV()){
            System.out.println("opps vertex out of bound !!!");
            return;
        }
        Node rNode = rNodeHead;
        if(isDirected()){
            while(rNode != null){
                Node cNode = rNode;
                if(rNode.rNext != null && rNode.rNext.edge.getSource() == vertex){
                    while(cNode.cNext != null){
                        cNode.rNext = cNode.rNext.rNext;
                        cNode = cNode.cNext;
                    }
                }

                cNode = rNode;
                while (cNode != null){
                    if (cNode.cNext != null && cNode.cNext.edge.getDest() == vertex){
                        cNode.cNext = cNode.cNext.cNext;
                        break;
                    }
                    cNode = cNode.cNext;
                }
                rNode = rNode.rNext;
            }
            setNumV(getNumV()-1);
        }
        else{//if not directed graph

            while(rNode != null){
                Node cNode = rNode;
                if(rNode.rNext != null && rNode.rNext.edge.getSource() == vertex){
                    while(cNode.cNext != null){
                        if (cNode.rNext.rNext == null){
                            cNode.rNext = null;
                        }
                        else{
                            cNode.rNext = cNode.rNext.rNext;
                            cNode.rNext.rNext.rPrev = cNode;
                        }
                        cNode = cNode.cNext;
                    }
                }
                cNode = rNode;
                while (cNode != null){
                    if (cNode.cNext != null && cNode.cNext.edge.getDest() == vertex){
                        if (cNode.cNext.cNext == null){
                            cNode.cNext = null;
                        }
                        else{
                            cNode.cNext = cNode.cNext.cNext;
                            cNode.cNext.cNext.cPrev = cNode;
                        }
                        break;
                    }
                    cNode = cNode.cNext;
                }
                rNode = rNode.rNext;
            }
            setNumV(getNumV()-1);
        }
    }

    /** Determine whether an edge exists.
     @param source The source vertex
     @param dest The destination vertex
     @return true if there is an edge from source to dest
     */
    public boolean isEdge(int source, int dest) {
        if (source > getNumV() || dest > getNumV()){
            System.out.println("opps out of bound !!!!");
            return false;
        }
        Node rNode = rNodeHead;
        while (rNode != null){
            if (rNode.edge != null && rNode.edge.getSource() == source){
                Node cNode  = rNode;
                while (cNode != null){
                    if (cNode.edge != null && cNode.edge.getDest() == dest){
                        return true;
                    }
                    cNode = cNode.cNext;
                }
            }
            rNode = rNode.rNext;
        }
        return false;
    }

    /** Get the edge between two vertices. If an
     edge does not exist, an Edge with a weight
     of Double.POSITIVE_INFINITY is returned.
     @param source The source
     @param dest The destination
     @return the edge between these two vertices
     */
    public Edge getEdge(int source, int dest) {

        Edge target = new Edge(source, dest, Double.POSITIVE_INFINITY);
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
    public void loadEdgesFromFile(BufferedReader bufferedReader) throws IOException {

        String line;
        while ( (line = bufferedReader.readLine()) != null && line.length() != 0){

            Scanner sc = new Scanner(line);
            int source = sc.nextInt();
            int dest = sc.nextInt();
            double weight = 1.0;

            if (sc.hasNextDouble()) {
                weight = sc.nextDouble();
            }
            insert(new Edge(source, dest, weight));
        }
    }

    /**
     * displays graph in row order
     */
    public void printGraph(){
        if (isDirected()) {
            System.out.println("*****************************************");
            System.out.println("using Row node:");
            Node rNode = rNodeHead;

            while (rNode != null) {
                Node tempNode = rNode;
                while (tempNode.cNext != null) {
                    System.out.print("[" + tempNode.cNext.edge.getSource() + "," + tempNode.cNext.edge.getDest() + "]");
                    if (tempNode.cNext.cNext != null)
                        System.out.print("-->");
                    tempNode = tempNode.cNext;
                }
                System.out.println();

                rNode = rNode.rNext;
            }
            System.out.println("*****************************************");
        }else{
            System.out.println("*****************************************");
            System.out.println("using Row node:");
            Node rNode = rNodeHead;

            while (rNode != null) {
                Node tempNode = rNode;
                while (tempNode.cNext != null) {
                    System.out.print("[" + tempNode.cNext.edge.getSource() + "," + tempNode.cNext.edge.getDest() + "]");
                    if (tempNode.cNext.cNext != null)
                        System.out.print("<-->");
                    tempNode = tempNode.cNext;
                }
                System.out.println();
                rNode = rNode.rNext;
            }
            System.out.println("*****************************************");
        }
    }

    /**
     * @return get row pointer
     */
    public Node getRNodeHead(){return rNodeHead;}

    /**
     * @return get column pointer
     */
    public Node getCNodeHead(){return  cNodeHead;}

    /**
     * @param source The source vertex
     * @return iterator to a particular edge and it's adjecents
     */
    public Iterator<Edge> edgeIterator(int source){

        it = new MyIterator(source);
        return it;
    }

    /**
     * class MyIterator to manipulate the graph iterator.
     */
    private class MyIterator implements Iterator<Edge>{

        Node iterator;

        MyIterator(int source){
            Node rNode = rNodeHead;
            while (rNode != null){
                if (rNode.edge != null && rNode.edge.getSource() == source) {
                    this.iterator = rNode;
                    break;
                }
                rNode = rNode.rNext;
            }
        }

        @Override
        public boolean hasNext() {
            if (iterator.cNext != null) {
                return true;
            }else {
                return false;
            }
        }
        public boolean hasPrevious() {
            if (iterator.cPrev != null) {
                return true;
            }else {
                return false;
            }
        }

        @Override
        public Edge next() {
            Edge temp = null;
            if (iterator.cNext != null)
                    temp = iterator.cNext.edge;
            iterator = iterator.cNext;
            return temp;
        }

        public Edge previous() {
            return iterator.cPrev.edge;
        }
    }
}