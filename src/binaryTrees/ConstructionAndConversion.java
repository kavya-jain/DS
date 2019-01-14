package binaryTrees;

import java.util.LinkedList;
import java.util.Queue;

class Node{
  static int preInd=0;
  int data;
  Node left, right;
  
  Node(){
    
  }
  
  Node(int data){
    this.data = data;
    left = right = null;
  }
  
  public int search(int[] in, int ele, int start, int end) {
    for(int i=start; i<=end; i++) {
      if(in[i] == ele)
        return i;
    }
    return -1;
  }
  
  public Node treeFromInorderAndPreorder(int[] in, int[] pre, int start, int end) {
    if(start>end)
      return null;
    
    Node temp = new Node(pre[preInd++]);
    if(start == end)
      return temp;
    
    int inInd = search(in, temp.data, start, end);
    
    temp.left = treeFromInorderAndPreorder(in, pre, start, inInd-1);
    temp.right = treeFromInorderAndPreorder(in, pre, inInd+1, end);
    
    return temp;
  }
  
  public Node treeFromInorderAndLevelorder(int[] in, int[] level, int start, int end) {
    if(start>end)
      return null;

    if(start == end)
      return new Node(level[start]);
    
    boolean found = false;
    int inInd=0;
    
    Node temp = null;
    for(int i=0; i<level.length; i++) {
      int d = level[i];
      for(int j=start; j<end; j++) {
        if(in[j] == data) {
          found = true;
          inInd = j;
          temp = new Node(data);
          break;
        }
      }
      if(found == true)
        break;
    }
    
    temp.left = treeFromInorderAndLevelorder(in, level, start, inInd-1);
    temp.right = treeFromInorderAndLevelorder(in, level, inInd+1, end);
    return temp;
  }
  
  public void postorder(Node root) {
    if(root==null)
      return;
    postorder(root.left);
    postorder(root.right);
    System.out.print(root.data+"->");
  }
  
  public void treeFromLevelOrder(int[] arr, int n) {
    int i=0;
    Node root = new Node(arr[0]);
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    Node current = null;
    while(i<=n/2) {
      current = q.remove();
      if(2*i+1<n) {
        current.left = new Node(arr[2*i+1]);
        q.add(current.left);
      }
      if(2*i+2<n) {
        current.right = new Node(arr[2*i+2]);
        q.add(current.right);
      }
      i++;
    }
    
    postorder(root);
  }
  
  public void ancestorMatrix(Node root, int n) {
    int[][] ancestor = new int[n][n];
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
          ancestor[i][j]=0;
      }
    }
    
    while(!q.isEmpty()) {
      Node current = q.remove();
      if(current.left!=null) {
        ancestor[current.data][current.left.data]=1;
        for(int i=0; i<n; i++) {
          if(ancestor[i][current.data]==1)
            ancestor[i][current.left.data]=1;
        }
        q.add(current.left);
      }
      if(current.right!=null) {
        ancestor[current.data][current.right.data]=1;
        for(int i=0; i<n; i++) {
          if(ancestor[i][current.data]==1)
            ancestor[i][current.right.data]=1;
        }
        q.add(current.right);
      }

    }
    
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        System.out.print(ancestor[i][j]+" ");
      }
      System.out.println();
    }
    
  }
  
  public Node constructSpecialTreeFromInorder(int[] inorder, int start, int end) {
    
    if(start>end)
      return null;
    
    int max = maxArray(inorder, start, end);
    Node temp = new Node(inorder[max]);
    temp.left = constructSpecialTreeFromInorder(inorder, start, max-1);
    temp.right = constructSpecialTreeFromInorder(inorder, max+1, end);
    
    return temp;
  }

  private int maxArray(int[] inorder, int start, int end) {
    int max=start;
    for(int i=start+1; i<=end; i++) {
      if(inorder[max]<inorder[i])
        max=i;
    }
    
    return max;
    
  }
  
  public Node BTFromParentArray(int[] parent) {
    Node[] created = new Node[parent.length];
    
    for(int i=0; i<created.length; i++) {
     created[i] = BTUtil(parent, i, created);
    }
    return ConstructionAndConversion.root;
    
  }
  
  public Node BTUtil(int[] parent, int i, Node[] created) {
    
    if(created[i]==null)
      return null;
    Node node = new Node(i);
    if(parent[i] == -1) {
      ConstructionAndConversion.root = node;
      return ConstructionAndConversion.root;
    }
    Node p;
    if(created[parent[i]]==null)
      p = BTUtil(parent, parent[i], created);
    else
      p = created[parent[i]];
    if(p.left==null)
      p.left = node;
    else
      p.right = node;
    return node;
    
  }
  
}

public class ConstructionAndConversion {
  
  static Node root;
  
  public static void main(String[] args) {
    Node node = new Node();
    int[] in = new int[] {1, 5, 10, 40, 30, 15, 28, 20};
    int[] pre = new int[] {5,1,0,4,2,3};
    int[] level = new int[] {1,2,3,4,5,6};
    int[] parent = new int[] {1, 5, 5, 2, 2, -1, 3};
//    Node root = node.treeFromInorderAndPreorder(in, pre, 0, in.length-1);
//    root.postorder(root);
//    Node root = node.treeFromInorderAndLevelorder(in, level, 0, in.length-1);
//    root.postorder(root);
//      int[] arr = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
//      node.treeFromLevelOrder(arr, arr.length);
//      root.ancestorMatrix(root, level.length);
      
//      root = node.constructSpecialTreeFromInorder(in, 0, in.length-1);
    root = node.BTFromParentArray(parent);
      root.postorder(root);
  }
  
}
