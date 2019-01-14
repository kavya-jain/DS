package graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GraphController {

  private Map<Integer, ArrayList<Integer>> graph;

  public GraphController(Integer vertex) {
    graph = new HashMap<Integer, ArrayList<Integer>>();
    for (int i = 1; i <= vertex; i++) {
      ArrayList<Integer> neighbour = new ArrayList<Integer>();
      graph.put(i, neighbour);
    }
  }

  public void addEdge(int start, int end) {
    if (start > graph.size() || end > graph.size())
      return;
    graph.get(start).add(end);
    graph.get(end).add(start);
  }

  public ArrayList<Integer> getNeighbours(int vertex) {
    if (vertex > graph.size())
      return null;
    return new ArrayList<Integer>(graph.get(vertex));
  }

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    GraphController graphObject = new GraphController(3);

    for (int i = 1; i <= 3; i++) {
      System.out.println("enter edge");
      int start = scan.nextInt();
      int end = scan.nextInt();
      graphObject.addEdge(start, end);

    }

    for (int i = 1; i <= 3; i++) {
      System.out.print(i + "->");
      ArrayList<Integer> edges = new ArrayList<>(graphObject.getNeighbours(i));
      for (int j : edges)
        System.out.print(j + ",");
      System.out.println();
    }

  }

}
