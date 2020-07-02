import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/** Class to implement the breadth-first search algorithm.
 *  @author mohammad ashraf yawar
 * */

public class BreadthFirstSearch {

    ArrayList<Integer> parent;
    Queue<Integer> queue;

    public BreadthFirstSearch(int numV){parent = new ArrayList<>(numV); queue = new LinkedList<>();}

    public Integer[] breadthFirstSearch(Graph graph, int start) {

        LinkedListGraph list = (LinkedListGraph) graph;
        LinkedListGraph.Node rNode = list.getRNodeHead();
        System.out.println("stating number:" +start);
        while (rNode != null){
            if(rNode.edge.getSource() == start){
                LinkedListGraph.Node cNode = rNode;
                cNode = cNode.cNext;
                parent.add(start);//new visited added to the list
                while (cNode != null){
                    if (!parent.contains(cNode.edge.getDest()) && !queue.contains(cNode.edge.getDest())){
                        queue.add(cNode.edge.getDest());
                    }
                    cNode = cNode.cNext;
                }
                break;
            }
            rNode = rNode.rNext;
        }
        breadthFirstSearch((LinkedListGraph) graph,queue.remove());
        System.out.println(parent);
        Integer[] array = parent.toArray(new Integer[0]);
        return array;
    }
    private void breadthFirstSearch(LinkedListGraph graph,int start){

       if(queue.isEmpty()){
           LinkedListGraph.Node rNode = graph.getRNodeHead();
           while (rNode != null){
               if(rNode.edge.getSource() == start){
                   LinkedListGraph.Node cNode = rNode;
                   cNode = cNode.cNext;
                   parent.add(start);//new visited added to the list
                   while (cNode != null){
                       if (!queue.contains(cNode.edge.getDest()) && !parent.contains(cNode.edge.getDest())){
                           queue.add(cNode.edge.getDest());
                       }
                       cNode = cNode.cNext;
                   }
               }
               rNode = rNode.rNext;
           }
           if(queue.isEmpty()){
               return;
           }
           else{
               breadthFirstSearch(graph,queue.remove());
           }
       }
       else{
           LinkedListGraph.Node rNode = graph.getRNodeHead();
           while (rNode != null){
               if(rNode.edge.getSource() == start){
                   LinkedListGraph.Node cNode = rNode;
                   cNode = cNode.cNext;
                   parent.add(start);//new visited added to the list
                   while (cNode != null){
                       if (!queue.contains(cNode.edge.getDest()) && !parent.contains(cNode.edge.getDest())){
                           queue.add(cNode.edge.getDest());
                       }
                       cNode = cNode.cNext;
                   }
               }
               rNode = rNode.rNext;
           }
           breadthFirstSearch(graph,queue.remove());
       }
    }
}