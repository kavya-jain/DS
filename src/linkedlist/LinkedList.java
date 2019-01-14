package linkedlist;

public class LinkedList {
  
  private Node head;
  
  public LinkedList() {
    head = null;
  }
  
  public Node getHead() {
    return head;
  }
  
  public void addNode(int data) {
    Node node = new Node(data,null);
    if(head == null)
      head = node;
    
    else {
      Node current = head;
      while(current.getNext() != null)
        current = current.getNext();
      current.setNext(node);
    }
  }
  
  public void addCycle(Node head) {
    Node node = head;
    while(node.getNext() != null)
      node = node.getNext();
    if(node.getNext() == null)
      node.setNext(head.getNext());
  }
  
  public void display() {
    Node current = head;
    while(current != null) {
      System.out.print("->" + current.getData());
      current = current.getNext();
    }
    System.out.println();
      
  }
  
  public void deleteNode(int data) {
    Node current = head;
    Node previous = null;
    if(current.getData() == data) {
      head = current.getNext();
      return;
    }
    
    while(current.getData() != data && current.getNext() != null) {
      previous = current;
      current = current.getNext();
    }
    if(current.getData() == data)
      previous.setNext(current.getNext());
    
    if(current.getNext() == null)
      System.out.println("not found");
    
  }
  
  public void addNodeOnPos(int data, int pos) {
    Node temp = new Node(data, null);
    if(pos == 0) {
      temp.setNext(head);
      head = temp;
    } else {
      Node current = head;
      Node previous = null;
      while(pos>0) {
        previous = current;
        current = current.getNext();
        pos--;
      }
      temp.setNext(current);
      previous.setNext(temp);
    }
  }
  
  public static int length(Node node) {
    if(node == null)
       return 0;
    return 1+length(node.getNext());
  }
  
  public int search(Node node, int x, int index) {
    if(node == null)
      return -1;
    
    index++;
    if(node.getData() == x)
      return index;
    return(search(node.getNext(), x, index));
  }
  
  public int getNth(Node node, int n) {
    int count = 1;
      if(node==null)
        return -1;
      if(count == n)
        return node.getData();
      return getNth(node.getNext(), n-1);
    }
  
  public int getMiddle(Node node) {
    Node slow = head, fast = head;
    if(node.getNext() == null)
      return node.getData();
    while(fast.getNext()!=null) {
      fast = fast.getNext();
      if(fast.getNext() == null)
        break;
      fast = fast.getNext();
      slow = slow.getNext();
    }
    return slow.getData();
  }
  
  public int noOfOccurence(Node node, int k) {
    int count = 0;
    while(node!=null) {
      if(node.getData() == k)
        count++;
      node = node.getNext();
    }
    return count;
  }
  
  public int detectAndCountLoop(Node node) {
    int len=0;
    Node slow = head, fast = head;
    if(fast == null || fast.getNext() == null)
      return -1;
    if(fast.getNext().getNext() == slow)
      return 2;
    fast = fast.getNext().getNext();
    while(slow!=null && fast!=null) {
      if(slow.getData() == fast.getData()) 
        break;
      slow = slow.getNext();
      fast = fast.getNext();
      if(fast == null)
        break;
      fast = fast.getNext();
    }
    
    if(fast!=null) {
      slow=slow.getNext();
      len++;
      while(slow!=fast) {
        len++;
        slow = slow.getNext();
      }
        
    }
    
    return len;
  }
}
