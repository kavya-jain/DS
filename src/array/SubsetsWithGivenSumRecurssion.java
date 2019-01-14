package array;

public class SubsetsWithGivenSumRecurssion {
  
  public static int count_sets(int[] arr, int total) {
    return rec(arr, total, arr.length-1);
  }
  
  public static int rec(int[] arr, int total, int i) {
    if(total == 0)
      return 1;
    if(total<0)
      return -1;
    if(i<0)
      return 0;
    if(total<arr[i])
      return rec(arr, total, i-1);
    return rec(arr, total, i-1) + rec(arr, total-arr[i], i-1);
  }
  
  public static void main(String[] args) {
    int[] arr = {2,4,6,10};
    System.out.println(count_sets(arr, 2));
  }

}
