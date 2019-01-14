package dp;

import java.util.HashMap;

public class SubsetsWithGivenSum {
  
  public static int count_sets(int[] arr, int total) {
    HashMap<String, Integer> mem = new HashMap<>();
    return dp(arr, total, arr.length-1, mem);
  }
  
  public static int dp(int[] arr, int total, int i, HashMap<String, Integer> mem) {
    String key = total + ":" + i;
    int to_return;
    if(mem.containsKey(key))
      return (int) mem.get(key);
    if(total == 0)
      return 1;
    if(total<0)
      return -1;
    if(i<0)
      return 0;
    if(total<arr[i])
      to_return = dp(arr, total, i-1, mem);
    else 
      to_return = dp(arr, total-arr[i], i-1, mem) + dp(arr, total, i-1, mem);
    mem.put(key, to_return);
    return to_return;
  }
  
  public static void main(String[] args) {
    int[] arr = {2,4,6,10};
    System.out.println(count_sets(arr, 16));
  }

}
