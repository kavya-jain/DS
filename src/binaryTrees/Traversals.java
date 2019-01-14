package binaryTrees;

import java.util.Deque;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class Tree {

  static int preInd = 0, count = 0;
  static Tree nx = null;
  int data;
  boolean visited;
  Tree left, right, next;

  public Tree(int data) {
    super();
    this.data = data;
    left = null;
    right = null;
    next = null;
  }

  public void inorder(Tree root) {
    Stack<Tree> s = new Stack<Tree>();
    Tree current = root;
    s.push(current);
    while (current != null && !s.isEmpty()) {
      current = current.left;
      while (current == null && !s.isEmpty()) {
        current = s.pop();
        System.out.print(current.data + "->");
        current = current.right;
      }
      s.push(current);
    }
  }

  public void preorder(Tree root) {
    if (root == null)
      return;

    Deque<Tree> s = new LinkedList<Tree>();
    Tree current = root;
    System.out.print(current.data + "->");
    if (current.right != null)
      s.addFirst(current.right);
    current = current.left;
    while (current != null) {
      System.out.print(current.data + "->");
      if (current.right != null)
        s.addFirst(current.right);
      current = current.left;
      while (current == null && !s.isEmpty()) {
        current = s.removeFirst();
        System.out.print(current.data + "->");
        if (current.right != null)
          s.addFirst(current.right);
        current = current.left;
      }
    }
  }

  public void postorder(Tree root) {
    Deque<Tree> s = new LinkedList<Tree>();
    while (root != null) {
      if (root.right != null)
        s.addFirst(root.right);
      s.addFirst(root);
      root = root.left;
      while (root == null && !s.isEmpty()) {
        root = s.removeFirst();
        if (root.right != null && root.right == s.peekFirst()) {
          Tree rightChild = s.removeFirst();
          s.addFirst(root);
          root = rightChild;
        } else {
          System.out.print(root.data + "->");
          root = null;
        }
      }
    }
  }

  public void postFromPreIn(int[] in, int[] pre, int start, int end) {

    if (start > end)
      return;
    int inInd = search(in, pre[preInd++], start, end);

    postFromPreIn(in, pre, start, inInd - 1);
    postFromPreIn(in, pre, inInd + 1, end);
    System.out.print(in[inInd] + "->");
  }

  private int search(int[] in, int i, int start, int end) {
    int j;
    for (j = start; j < end; j++) {
      if (in[j] == i)
        return j;
    }
    return j;
  }

  public void populateInSucc(Tree root) {
    if (root != null) {
      populateInSucc(root.right);
      root.next = next;
      next = root;
      populateInSucc(root.left);
    }
  }

  /*
   * public Tree inorderSuccessor(Tree root, int d) { if(root==null) return
   * null; if(root.data == d) { root = root.right; if(root==null) return null;
   * while(root.left!=null) root = root.left; return root; } Queue<Tree> q = new
   * LinkedList<>(); Tree parent = root; if(root.left!=null) q.add(root.left);
   * if(root.right!=null) q.add(root.right); while(!q.isEmpty()) { Tree current
   * = q.remove(); if(current.data == d) { if(current.right!=null) { current =
   * current.right; while(current.left!=null) current = current.left; return
   * current; } else { return parent; } } else { if(current.left != null)
   * q.add(current.left); if(current.right!=null) q.add(current.right); } }
   * return null; }
   */

  public void nInorderNode(Tree node, int n) {
    if (node == null)
      return;
    if (count <= n) {
      nInorderNode(node.left, n);
      count++;
      if (count == n)
        System.out.println(node.data);
      nInorderNode(node.right, n);
    }
  }

  public void nPostorderNode(Tree node, int n) {
    if (node == null)
      return;
    if (count <= n) {
      nPostorderNode(node.left, n);
      nPostorderNode(node.right, n);
      count++;
      if (count == n)
        System.out.println(node.data);
    }
  }

  public int height(Tree node) {
    if (node == null)
      return 0;
    count++;
    int lht = height(node.left);
    int rht = height(node.right);
    if (lht > rht)
      return lht + 1;
    return rht + 1;
  }

  public void printSpiral(Tree node) {
    if (node == null)
      return;

    int ht = height(node);
    boolean ltr = true;
    int flag = 0;
    for (int i = 1; i <= ht; i++) {
      print(node, i, ltr);
      flag++;
      if (flag % 2 == 0) {
        flag = 0;
        ltr = !ltr;
      }

      // System.out.println();
    }
  }

  public void print(Tree node, int ht, boolean ltr) {
    if (node == null)
      return;
    if (ht == 1) {
      System.out.print(node.data + "->");
    } else if (ht > 1) {
      if (ltr) {
        print(node.left, ht - 1, ltr);
        print(node.right, ht - 1, ltr);
      } else {
        print(node.right, ht - 1, ltr);
        print(node.left, ht - 1, ltr);
      }
    }

  }

  public void reverseLevelOrder(Tree node) {
    int ht = height(node);
    for (int i = ht; i >= 1; i--)
      printRev(node, i);
  }

  public void printRev(Tree node, int level) {
    if (node == null)
      return;
    if (level == 1)
      System.out.print(node.data + "->");
    else if (level > 1) {
      printRev(node.left, level - 1);
      printRev(node.right, level - 1);
    }
  }

  public void perfectTreeTraversal(Tree root) {
    if (root == null)
      return;

    Tree l, r;
    Queue<Tree> q = new LinkedList<>();
    if (root.left != null) {
      q.add(root.left);
      q.add(root.right);
    }
    System.out.print(root.data + "->");
    while (!q.isEmpty()) {
      l = q.remove();
      r = q.remove();
      System.out.print(l.data + "->" + r.data + "->");
      if (l.left != null) {
        q.add(l.left);
        q.add(r.right);
        q.add(l.right);
        q.add(r.left);
      }
    }
  }

  public void perfectTreeTraversalReverse(Tree root) {
    if (root == null)
      return;
    Tree l = root.left, r = root.right;
    if (l == null) {
      System.out.println(root.data);
      return;
    }
    Deque<Tree> s = new LinkedList<>();
    Queue<Tree> q = new LinkedList<>();
    q.add(r);
    q.add(l);
    s.push(root);
    while (!q.isEmpty()) {
      r = q.remove();
      l = q.remove();
      s.push(r);
      s.push(l);
      if (r.left != null) {
        q.add(r.left);
        q.add(l.right);
        q.add(r.right);
        q.add(l.left);
      }
    }

    while (!s.isEmpty()) {
      System.out.print(s.pop().data + "->");
    }
  }

  public void morrisInorder(Tree root) {
    if (root == null)
      return;

    Tree current = root;
    while (current != null) {
      if (current.left == null) {
        System.out.print(current.data + "->");
        current = current.right;
      } else {
        Tree pred = current.left;
        while (pred.right != null && pred.right != current)
          pred = pred.right;
        if (pred.right == null) {
          pred.right = current;
          current = current.left;
        } else {
          System.out.print(current.data + "->");
          pred.right = null;
          current = current.right;
        }
      }
    }
  }

  public void postorderNoStack(Tree root) {
    if (root == null)
      return;
    Tree temp = root;
    while (temp != null && temp.visited == false) {
      if (temp.left != null && temp.left.visited == false)
        temp = temp.left;
      else if (temp.right != null && temp.right.visited == false)
        temp = temp.right;
      else {
        System.out.print(temp.data + "->");
        temp.visited = true;
        temp = root;
      }
    }
  }

  public void diagonalPrint(Tree root) {
    if (root == null)
      return;
    Queue<Tree> q = new LinkedList<Tree>();
    Tree current = root;
    q.add(root);
    q.add(null);
    while (!q.isEmpty()) {
      current = q.remove();
      if (current == null) {
        q.add(null);
        System.out.println();
        if (q.peek() == null)
          break;
      }
      while (current != null) {
        System.out.print(current.data + " ");
        if (current.left != null)
          q.add(current.left);
        current = current.right;
      }
    }
  }

  public void boundaryTraversal(Tree root) {
    if (root == null)
      return;

    LinkedHashSet<Integer> set = new LinkedHashSet<>();
    set.add(root.data);
    Tree current = root.left;
    while (current != null) {
      set.add(current.data);
      if (current.left != null)
        current = current.left;
      else
        current = current.right;
    }

    findLeaves(root, set);
    int ht = height(root);
    for (int i = ht; i >= 1; i--) {
      printRightBottomUp(root, i, set);
    }

    for (Integer a : set)
      System.out.print(a + " ");
  }

  public void findLeaves(Tree root, LinkedHashSet<Integer> set) {
    if (root == null)
      return;
    if (root.left == null && root.right == null)
      set.add(root.data);
    else {
      findLeaves(root.left, set);
      findLeaves(root.right, set);
    }
  }

  public void printRightBottomUp(Tree root, int level, LinkedHashSet<Integer> set) {
    if (root == null)
      return;
    if (level == 1)
      set.add(root.data);
    else if (level > 1) {
      if (root.right != null)
        printRightBottomUp(root.right, level - 1, set);
      else
        printRightBottomUp(root.left, level - 1, set);
    }
  }

  public float density(Tree root) {
    if (root == null)
      return 0f;
    count = 0;
    int ht = height(root);
    float dens = (float) count / ht;
    return dens;
  }

  public int depthFromPreorder(char[] pre) {
    if (pre.length == 0)
      return 0;

    int count = 0, l = 0;
    for (char c : pre) {
      if (c == 'l')
        l++;
    }
    l = l / 2;

    while (l > 1) {
      count++;
      l /= 2;
    }

    return count + 2;
  }

  public int numberOfTreeFromPreorder(int n) {
    if (n == 0)
      return 1;
    int[] BT = new int[n + 1];
    BT[0] = 1;
    BT[1] = 1;
    BT[2] = 2;

    for (int i = 3; i <= n; i++) {
      for (int j = i - 1; j >= 0; j--) {
        BT[i] += BT[j] * BT[i - j - 1];
      }
    }
    return BT[n];
  }

}

public class Traversals {

  public static void main(String[] args) {

    Tree root = new Tree(10);
    root.left = new Tree(30);
    root.right = new Tree(20);
//    root.left.left = new Tree(4);
//    root.left.right = new Tree(5);
    root.right.left = new Tree(5);
    root.right.right = new Tree(15);
    root.preorder(root);

    /*
     * root.inorder(root); System.out.println(); root.preorder(root);
     * System.out.println(); root.postorder(root); System.out.println(); int
     * in[] = { 4, 2, 5, 1, 3, 6 }; int pre[] = { 1, 2, 4, 5, 3, 6 }; int len =
     * in.length; root.postFromPreIn(in, pre, 0, len - 1);
     * 
     * System.out.println(); root.nInorderNode(root, 6); Tree.count = 0;
     * root.nPostorderNode(root, 5); System.out.println(root.height(root));
     * root.printSpiral(root); System.out.println();
     * root.reverseLevelOrder(root); root.perfectTreeTraversal(root);
     * System.out.println(); root.perfectTreeTraversalReverse(root);
     * root.morrisInorder(root); root.postorderNoStack(root);
     * root.diagonalPrint(root); root.boundaryTraversal(root);
     * System.out.println(root.density(root));
     * System.out.println(root.depthFromPreorder( new char[] { 'n', 'n', 'l',
     * 'l', 'n', 'n', 'n', 'l', 'l', 'n', 'n', 'l', 'l' }));
     * System.out.println(root.numberOfTreeFromPreorder(9));
     */
  }

}
