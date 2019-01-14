package array;

public class KSmallestElementsInArray {
  
  public static void buildHeap(int[] heap, int k) {
    for(int i=k/2; i>=0; i--)
      heapify(heap, k, i);
  }

  private static int max(int[] heap, int k) {
    int largest = 0;
    for(int i=1; i<k; i++) {
      if(heap[largest] < heap[i])
        largest = i;
    }
    return largest;
  }
  
  public static void swap(int[] heap, int k, int smallest) {
    int temp = heap[k];
    heap[k] = heap[smallest];
    heap[smallest] = temp;
  }
  
  public static void heapify(int[] heap, int k, int i) {
    int left = 2*i+1;
    int right = 2*i+2;
    int smallest = i;
    
    if(left <= k && heap[smallest] > heap[left])
      smallest = left;
    if(right <= k && heap[smallest] > heap[right])
      smallest = right;
    
    if(smallest != i) {
      swap(heap, i, smallest);
      heapify(heap, k, (i-1)/2);
    }
  }
  
  public static void main(String[] args) {
    int[] arr = {3,1,2,7,4,0,9,5,8,-1,-10,-100};
    int n = arr.length;
    int k=4;
    
    //Initial min heap
    buildHeap(arr, 3);
    
    for(int i=k; i<n; i++) {
      int index = max(arr,k);
      if(arr[i]<arr[index]) {
        arr[index] = arr[i];
        heapify(arr, k-1, (index-1)/2);
      }
    }
    
    for(int a=0; a<k; a++)
      System.out.print(arr[a] + " ");
    
  }

}
