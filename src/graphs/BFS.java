package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Graph {
  int v;
  LinkedList<Integer>[] adj;
  
  Graph(int v){
    this.v = v;
    adj = new LinkedList[v];
    for(int i=0; i<v; i++)
      adj[i]=new LinkedList<>();
  }
  
  public void addEdge(int v, int w) {
    this.adj[v].add(w);
    this.adj[w].add(v);
  }
  
  void DFSearch(int s) {
    boolean[] visited = new boolean[v];
    Stack<Integer> stack = new Stack<>();
    stack.push(s);
    visited[s] = true;
    
    while(!stack.isEmpty()) {
      int current = stack.pop();
      System.out.print(current+" ");
      for(int i=0; i<adj[current].size(); i++) {
        if(visited[adj[current].get(i)]==false) {
          visited[adj[current].get(i)]=true;
          stack.push(adj[current].get(i));
        }
      }
    }
    
  }
  
  void BFSearch(int s) {
    boolean[] visited = new boolean[v];
    Queue<Integer> q = new LinkedList<>();
    q.add(s);
    visited[s]=true;
    
    while(!q.isEmpty()) {
      int current = q.remove();
      System.out.print(current+" ");
      for(int i=0; i<adj[current].size(); i++) {
        if(visited[adj[current].get(i)]!=true) {
          visited[adj[current].get(i)] = true;
          q.add(adj[current].get(i));
        }
      }
    }
  }

}

public class BFS {
  
  public static void main(String[] args) {
    
    Graph graph = new Graph(6);
    graph.addEdge(0,1);
    graph.addEdge(0,2);
    graph.addEdge(1,3);
    graph.addEdge(1,4);
    graph.addEdge(2,4);
    graph.addEdge(3,4);
    graph.addEdge(3,5);
    graph.addEdge(4,5);
    
//    graph.BFSearch(0);
    graph.DFSearch(0);
    System.out.println();
  }

}
