import java.util.ArrayList;
import java.util.Stack;

/** Class to implement the DepthFirstSearch search algorithm.
 *  @author mohammad ashraf yawar
 * */
public class DepthFirstSearch {

  ArrayList<Integer> parent;
  ArrayList<Integer> visted;
  Stack<Integer> stack;

  public DepthFirstSearch(int numV){parent = new ArrayList<>(numV); stack = new Stack<>(); visted = new ArrayList<>();}

  public Integer[] depthFirstSearch(Graph graph, int start) {

    LinkedListGraph list = (LinkedListGraph) graph;
    LinkedListGraph.Node rNode = list.getRNodeHead();
    System.out.println("starting number:" + start);

    while (rNode != null){
      if(rNode.edge.getSource() == start){
        visted.add(start);//new visited added to the list
        stack.push(start);
        break;
      }
      rNode = rNode.rNext;
    }
    depthFirstSearch((LinkedListGraph) graph,start);
    System.out.println("parent: "+parent);
    Integer[] array = parent.toArray(new Integer[0]);
    return array;
  }
  private void depthFirstSearch(LinkedListGraph graph,int start){

    if(stack.isEmpty()){
      System.out.println("stack empty");
      return;
    }
    else{
      LinkedListGraph.Node rNode = graph.getRNodeHead();
      while (rNode != null){
        if(rNode.edge.getSource() == start){
          LinkedListGraph.Node cNode = rNode;
          cNode = cNode.cNext;
          visted.add(start);//new visited added to the list
          while (cNode != null){
            if (!visted.contains(cNode.edge.getDest())){
              visted.add(cNode.edge.getDest());
              stack.push(cNode.edge.getDest());
              depthFirstSearch(graph,cNode.edge.getDest());
            }
            cNode = cNode.cNext;
          }
          if (!parent.contains(rNode.edge.getSource())){
            parent.add(rNode.edge.getSource());
            stack.pop();
          }
          break;
        }
        rNode = rNode.rNext;
      }
    }
  }
}