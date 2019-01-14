package binaryTrees;

class Graph {
  
  int data;
  Graph left, right;
  
  Graph(int data){
    this.data = data;
    left=right=null;
  }

}

class LinkedList {
  Graph data;
  LinkedList next;
  
  public LinkedList(Graph data) {
    this.data = data;
    next = null;
  }
}

public class BinaryTree {
  
  Graph root;
  LinkedList head;
  
  BinaryTree() {
    this.root = null;
  }
  
  BinaryTree(int data) {
    this.root = new Graph(data);
  }
  
  public Graph getRoot() {
    return root;
  }
  
  public void addInQueue(LinkedList node) {
    if(head == null) 
      head = node;
    else {
      LinkedList current = head;
      while(current.next!=null)
        current = current.next;
      current.next = node;
    }
  }
  
  public LinkedList getHead(LinkedList node) {
    LinkedList current = node;
    head = node.next;
    return current;
  }
  
  
  public void addNode(Graph node) {
    if(root == null) {
      root = node;
      return;
    }
    LinkedList start = new LinkedList(root);
    addInQueue(start);
    while(head!=null) {
      LinkedList last = getHead(head);
      if(last.data.left == null) {
        last.data.left = node;
        break;
      }
      else
        addInQueue(new LinkedList(last.data.left)); 
      if(last.data.right == null) {
        last.data.right = node;
        break;
      }
      else
        addInQueue(new LinkedList(last.data.right)); 
    }
    
  }
  
  public Graph searchNode(int key) {
    if(root == null)
      return null;
    if(root.data == key)
      return root;
    head = null;
    int flag = -1;
    Graph temp = null;
    LinkedList start = new LinkedList(root);
    addInQueue(start);
    while(head!=null) {
      LinkedList last = getHead(head);
      if(last.data.left!=null) {
        if(last.data.left.data == key) {
          flag = 0;
          temp = last.data.left;
          break;
        }
        else
          addInQueue(new LinkedList(last.data.left));
      }
      if(last.data.right!=null) {
        if(last.data.right.data == key) {
          flag = 0;
          temp = last.data.right;
          break;
        }
        else
          addInQueue(new LinkedList(last.data.right));
      }
      
    }
    if(flag < 0 )
      return new Graph(-1);
    return temp;
  }
  
  public Graph getLast() {
    if(root==null)
      return null;
   
    Graph parent = root;
    LinkedList last;
    addInQueue(new LinkedList(root));
    while(head!=null) {
      last = getHead(head);
      if(last.data.left!=null) {
        addInQueue(new LinkedList(last.data.left));
        if(last.data.left.left == null && last.data.left.right == null)
          parent = last.data;
      }
      if(last.data.right!=null) {
        addInQueue(new LinkedList(last.data.right));
        if(last.data.right.left == null && last.data.right.right == null)
          parent = last.data;
      }
    }
    return parent;
  }
  
  public void delNode(int key) {
    Graph toDelete = searchNode(key);
    Graph lastParent = getLast();
    if(lastParent.right!=null) {
      if(toDelete.data != lastParent.right.data)
        toDelete.data = lastParent.right.data;
      lastParent.right = null;
    }
      
    else {
      if(toDelete.data != lastParent.left.data)
        toDelete.data = lastParent.left.data;
      lastParent.left = null; 
    }
     
    System.out.println("deleted");
  }
  
  public Graph getDeepestRight() {
    if(root == null || root.right == null)
      return null;
    addInQueue(new LinkedList(root));
    Graph result = null;
    while(head!=null) {
      LinkedList last = getHead(head);
      
      if(last.data.left!=null)
        addInQueue(new LinkedList(last.data.left));
      if(last.data.right!=null) {
        addInQueue(new LinkedList(last.data.right));
        if(last.data.right.left == null && last.data.right.right == null)
          result = last.data.right;
      }
    }
    return result;
  }
  
  public void inorder(Graph node) {
    if(node==null) {
      return;
    }
    
    inorder(node.left);
    System.out.print(node.data+"->");
    inorder(node.right);
    
  }
  
  public int checkContinuity() {
    if(root == null)
      return 0;
    if(root.left == null && root.right == null)
      return 1;
    
    addInQueue(new LinkedList(root));
    while(head!=null) {
      LinkedList last = getHead(head);
      if(last.data.left!=null) {
        if(Math.abs(last.data.left.data - last.data.data)!=1)
          return -1;
        addInQueue(new LinkedList(last.data.left));
      }
      if(last.data.right!=null) {
        if(Math.abs(last.data.right.data - last.data.data)!=1)
          return -1;
        addInQueue(new LinkedList(last.data.right));
      }
    }
    return 1;
  }
  
  public boolean checkFoldability() {
    if(root == null)
      return true;
    
    return foldUtil(root.left, root.right);
  }
  
   private boolean foldUtil(Graph n1, Graph n2) {
     if(n1 == null && n2 == null)
       return true;
     if(n1 == null || n2 == null)
       return false;
     
    return foldUtil(n1.left, n2.right) && foldUtil(n1.right, n2.left);
  }
   
  public boolean checkSymmetry() {
    if(root==null)
      return true;
    return symmUtil(root.left, root.right);
  }

  private boolean symmUtil(Graph n1, Graph n2) {
    if(n1==null && n2==null)
      return true;
    if(n1==null || n2==null)
      return false;
    if(n1.data!=n2.data)
      return false;
    return symmUtil(n1.left, n2.right) && symmUtil(n1.right, n2.left);
  }

  public static void main(String[] args) {
     
     BinaryTree tree = new BinaryTree();
     tree.addNode(new Graph(1));
     tree.addNode(new Graph(2));
     tree.addNode(new Graph(5));
     tree.addNode(new Graph(3));
     tree.addNode(new Graph(4));
     tree.addNode(new Graph(4));
     tree.addNode(new Graph(3));
     
/*     Graph searched = tree.searchNode(5);
     System.out.println(searched.data + "->");     
     tree.delNode(2);
     tree.delNode(5);
     Graph rightmost = tree.getLast();
     System.out.println((rightmost.right != null) ? rightmost.right.data : rightmost.left.data);
     Graph deepestRight = tree.getDeepestRight();
     if(deepestRight == null)
       System.out.println("No rightmost node");
     else
       System.out.println(deepestRight.data);*/
     
     tree.inorder(tree.getRoot());
     System.out.println();
     System.out.println(tree.checkContinuity());
     System.out.println(tree.checkFoldability());
     System.out.println(tree.checkSymmetry());
  }
}
