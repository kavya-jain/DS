package graphs;

import java.util.ArrayList;
import java.util.Stack;

public class GraphByNode {

  private String data;
  private ArrayList<GraphByNode> neighbours;

  public GraphByNode(String data) {
    this.data = data;
    neighbours = new ArrayList<>();
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public GraphByNode[] getNeighbours() {
    return neighbours.toArray(new GraphByNode[0]);
  }

  public void setNeighbours(GraphByNode[] d) {
    for(int i=0; i<d.length; i++)
      neighbours.add(d[i]);
  }
  
  public static void main(String[] args) {
    GraphByNode A = new GraphByNode("A");
    GraphByNode B = new GraphByNode("B");
    GraphByNode C = new GraphByNode("C");
    GraphByNode D = new GraphByNode("D");
    GraphByNode E = new GraphByNode("E");
    GraphByNode F = new GraphByNode("F");
    
    A.setNeighbours(new GraphByNode[] {B,C,D});
    B.setNeighbours(new GraphByNode[] {A,F});
    C.setNeighbours(new GraphByNode[] {A,D,E});
    D.setNeighbours(new GraphByNode[] {A,C,F});
    E.setNeighbours(new GraphByNode[] {C});
    F.setNeighbours(new GraphByNode[] {B,D});
    
    DFS(A);
  }

  private static void DFS(GraphByNode start) {
    
    ArrayList<GraphByNode> visited = new ArrayList<>();
    Stack<GraphByNode> stack = new Stack<>();
    stack.push(start);
    
    while(!stack.empty()) {
      GraphByNode current = stack.pop();
      if(!visited.contains(current)) {
        visited.add(current);
        System.out.println("--"+current.getData());
        GraphByNode[] neighbours = current.getNeighbours();
        for(int i=neighbours.length-1; i>=0; i--)
          stack.push(neighbours[i]);
      }
    }
    
    System.out.println();
  }

}
