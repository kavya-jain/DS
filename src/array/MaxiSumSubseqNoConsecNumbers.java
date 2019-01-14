package array;

import java.io.*;

public class MaxiSumSubseqNoConsecNumbers {
  static int[] arr;
  
  public static int maxProfit(int[] arr, int n){
      int inc = arr[0], exc = 0, newExc;
      for(int i=1; i<n; i++){
          newExc = Math.max(inc, exc);
          inc = exc + arr[i];
          exc = newExc;
      }
      
      return Math.max(inc, exc);
      
  }
  
public static void main (String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int tc = Integer.parseInt(br.readLine());
  while (tc-- > 0) {
    int n = Integer.parseInt(br.readLine());
    arr = new int[n];
    String[] str = br.readLine().trim().split(" ");
    for (int i = 0; i < n; i++)
      arr[i] = Integer.parseInt(str[i]);
    System.out.println(maxProfit(arr,n));
  }
}

}
