package linkedlist;

public class LinkedListTest {

  public static void main(String[] args) {

    LinkedList list = new LinkedList();
    list.addNode(1);
    list.addNode(2);
    list.addNode(3);
    list.addNode(4);
    list.addNode(5);

//  list.deleteNode(2);
    
//    list.addNodeOnPos(5,4);
//    list.display();
//    System.out.println(LinkedList.length(list.getHead()));
//    System.out.println(list.search(list.getHead(), 1,-1));
//    System.out.println(list.getNth(list.getHead(), 2));
//    System.out.println(list.getMiddle(list.getHead()));
//    System.out.println(list.noOfOccurence(list.getHead(), 4));
    list.addCycle(list.getHead());
    System.out.println(list.detectAndCountLoop(list.getHead()));

  }
}
