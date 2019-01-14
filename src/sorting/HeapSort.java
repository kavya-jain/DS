package sorting;

public class HeapSort {

  private static void swap(int[] arr, int max, int i) {
    int temp = arr[i];
    arr[i] = arr[max];
    arr[max] = temp;
  }

  public static void buildHeap(int[] arr, int n) {
    for (int i = n / 2; i >= 0; i--) {
      heapify(arr, n, i);
    }
  }

  private static void heapify(int[] arr, int n, int i) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;

    int max = i;
    if (left<=n && arr[i] < arr[left])
      max = left;
    if (right<=n && arr[max] < arr[right])
      max = right;
    if (max != i) {
      swap(arr, max, i);
      heapify(arr, n, max);
    }
  }

  public static void main(String[] args) {
    
    int[] arr = {900,940,950,1100,1500,1800};
    buildHeap(arr, arr.length-1);
    
    int n=arr.length-1;
    for(int i=arr.length-1; i>=0; i--) {
      swap(arr, 0, n);
      n--;
      heapify(arr, n, 0);
    }
    for(int a : arr)
      System.out.print(a+" ");
  }
}
