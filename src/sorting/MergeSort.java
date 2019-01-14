//Stable sort

package sorting;

public class MergeSort {
  
  public static void mergeSort(int[] arr, int start, int end) {
    
    if(start<end) {
      int mid = (start+end)/2;
      mergeSort(arr, start, mid);
      mergeSort(arr, mid+1, end);
      
      merge(arr, start, mid, end);
    }
  }
  
  public static void merge(int[] arr, int start, int mid, int end) {
    int p=start, q=mid+1, k=0;
    int[] A = new int[end-start+1];
    
    for(int i=start; i<=end; i++) {
      if(p>mid) 
        A[k++] = arr[q++];
      else if(q>end)
        A[k++] = arr[p++];
      else if(arr[p]>arr[q])
        A[k++] = arr[q++];
      else
        A[k++] = arr[p++];
    }
    
    for(int i=0; i<k; i++)
      arr[start++] = A[i];
  }
  
  public static void main(String[] args) {
    int[] arr = {9,2,5,1,6,3,8,9,0};
    mergeSort(arr, 0, 8);
    for(int a:arr)
      System.out.println(a+" ");
  }

}
