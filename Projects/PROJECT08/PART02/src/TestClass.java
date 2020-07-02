import javax.xml.stream.events.EntityDeclaration;
import java.util.Iterator;

public class TestClass {
    public static void main(String[] args) {

        System.out.println("************************************************ UNDIRECTED GRAPH ************************************************");
        System.out.println("Creating linked list graph...");
        LinkedListGraph graph = new LinkedListGraph(5, false);
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph.getNumV());
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch(graph.getNumV());

        //insert into graph:
        System.out.println("inserting Edges...");
        graph.insert(new Edge(0,0));
        graph.insert(new Edge(0,4));

        graph.insert(new Edge(1,0));
        graph.insert(new Edge(1,4));

        graph.insert(new Edge(3,1));
        graph.insert(new Edge(3,3));
        graph.insert(new Edge(3,4));

        graph.insert(new Edge(2,0));
        graph.insert(new Edge(2,2));
        graph.insert(new Edge(2,4));

        graph.insert(new Edge(4,1));
        graph.insert(new Edge(4,2));
        graph.insert(new Edge(4,3));

        System.out.println("");
        graph.printGraph();


        //delete from graph
        System.out.println("delete an edge (4,2)...");
        graph.delete(new Edge(4,2));
        graph.printGraph();

        //breath first search
        System.out.println("breath first search...");
        breadthFirstSearch.breadthFirstSearch(graph,4);
        System.out.println();

        //depth first search
        System.out.println("depth first search...");
        depthFirstSearch.depthFirstSearch(graph,2);

        //insert vertex
        System.out.println("inserting Vertex...");
        graph.insertVertex();
        graph.printGraph();

        System.out.println("iterating edge 2...");
        Iterator iterator = graph.edgeIterator(2);
        System.out.println(iterator.hasNext());
        while (iterator.hasNext()){
            Edge temp = (Edge) iterator.next();
            System.out.println(temp.getDest());
        }
        System.out.println("iterating edge 4...");
        iterator = graph.edgeIterator(4);
        System.out.println("has next :" + iterator.hasNext());
        while (iterator.hasNext()){
            Edge temp = (Edge) iterator.next();
            System.out.println(temp.getDest());
        }
        System.out.println("************************************************ DIRECTED GRAPH ************************************************");
        System.out.println("Creating linked list graph...");
        graph = new LinkedListGraph(5, true);
        breadthFirstSearch = new BreadthFirstSearch(graph.getNumV());
        depthFirstSearch = new DepthFirstSearch(graph.getNumV());

        //insert into graph:
        System.out.println("inserting Edges...");
        graph.insert(new Edge(0,0));
        graph.insert(new Edge(0,4));

        graph.insert(new Edge(1,0));
        graph.insert(new Edge(1,4));

        graph.insert(new Edge(3,1));
        graph.insert(new Edge(3,3));

        graph.insert(new Edge(2,0));
        graph.insert(new Edge(2,2));
        graph.insert(new Edge(2,4));

        graph.insert(new Edge(4,1));
        graph.insert(new Edge(4,2));
        graph.insert(new Edge(4,3));

        System.out.println("");
        graph.printGraph();

        //delete from graph
        System.out.println("delete an edge (4,2)...");
        graph.delete(new Edge(4,2));
        graph.printGraph();

        //breath first search
        System.out.println("breath first search...");
        breadthFirstSearch.breadthFirstSearch(graph,4);
        System.out.println();

        //depth first search
        System.out.println("depth first search...");
        depthFirstSearch.depthFirstSearch(graph,2);

        //insert vertex
        System.out.println("inserting Vertex...");
        graph.insertVertex();
        graph.printGraph();

        System.out.println("iterating edge 2...");
        iterator = graph.edgeIterator(2);
        System.out.println(iterator.hasNext());
        while (iterator.hasNext()){
            Edge temp = (Edge) iterator.next();
            System.out.println(temp.getDest());
        }
        System.out.println("iterating edge 4...");
        iterator = graph.edgeIterator(4);
        System.out.println("has next :" + iterator.hasNext());
        while (iterator.hasNext()){
            Edge temp = (Edge) iterator.next();
            System.out.println(temp.getDest());
        }

        System.out.println("is edge testing(2,4)...");
        System.out.println(graph.isEdge(2,4));
        System.out.println("is edge testing(0,3)...");
        System.out.println(graph.isEdge(0,3));
        System.out.println("is edge testing(4,4)...");
        System.out.println(graph.isEdge(4,4));
    }
}