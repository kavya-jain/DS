package binaryTrees;

import java.util.Arrays;

public class Heap {

  int size = 0;
  int capacity = 10;
  int[] items = new int[capacity];
  
  public void setItems(int[] items) {
    this.items = items;
  }
  public int[] getItems() {
    return this.items;
  }

  private int getParentIndex(int index) {
    return (index - 1) / 2;
  }

  private int getLeftChildIndex(int index) {
    return (index * 2) + 1;
  }

  private int getRightChildIndex(int index) {
    return (index * 2) + 2;
  }

  private int getParent(int index) {
    return items[getParentIndex(index)];
  }

  private int getLeftChild(int index) {
    return items[getLeftChildIndex(index)];
  }

  private int getRightChild(int index) {
    return items[getRightChildIndex(index)];
  }

  private boolean hasParent(int index) {
    return getParentIndex(index) >= 0;
  }

  private boolean hasLeftChild(int index) {
    return getLeftChildIndex(index) < size;
  }

  private void ensureCapacity() {
    if (size == capacity) {
      items = Arrays.copyOf(items, capacity * 2);
      capacity *= 2;
    }
  }

  private void swap(int a, int b) {
    int temp = items[a];
    items[a] = items[b];
    items[b] = temp;
  }

  public int peek() {
    if (size == 0)
      throw new IllegalStateException();
    return items[0];
  }

  public int poll() {
    if (size == 0)
      throw new IllegalStateException();
    int item = items[0];
    items[0] = items[size - 1];
    size--;
    heapifyDown();
    return item;
  }

  public void insert(int item) {
    ensureCapacity();
    items[size] = item;
    size++;
    heapifyUp();
  }

  public void heapifyDown() {
    int index = 0;
    while (hasLeftChild(index)) {
      int smaller = getLeftChildIndex(index);
      if (getLeftChild(index) > getRightChild(index))
        smaller = getRightChildIndex(index);
      if (items[index] < items[smaller])
        break;
      else {
        swap(index, smaller);

      }
      index = smaller;
    }
  }

  public void heapifyUp() {
    int index = size - 1;
    while (hasParent(index) && getParent(index) > items[index]) {
      swap(getParentIndex(index), index);
      index = getParentIndex(index);
    }
  }
  
  public static void main(String[] args) {
    Heap heap = new Heap();
    heap.insert(9);
    heap.insert(7);
    heap.insert(8);
    heap.insert(2);
    heap.insert(1);
    heap.insert(3);
    
    for(int i=0; i<6; i++)
      System.out.print(heap.poll()+ " ");
  }
}
