package dp;

import java.io.*;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
  
  static int[] arr;
  static int len = 1;
  
  public static int lis(int n) {
    
    int[] length = new int[n];
    int[] seq = new int[n];
    Arrays.fill(length, 1);
    seq[0]=-1;
    
    for(int i=1; i<n; i++) {
      for(int j=0; j<i; j++) {
        if(arr[j]<arr[i]) {
          if(length[i]<=length[j]+1) {
            length[i] = length[j]+1;
            seq[i] = j;
          }
        }
      }
    }
    
    int k=max(length);
    System.out.println(k);
//    while(k>=0) {
//      System.out.print(arr[k]+" ");
//      k = seq[k];
//    }
//    System.out.println();
//    for(int a : length)
//      System.out.print(a+" ");
    return length[k];
    
  }
  
  public static int maxSum(int[] arr, int n){
    int[] sums = new int[n];
    for(int i=0; i<n; i++)
      sums[i]=arr[i];
    int max=sums[0];
    for(int i=1; i<n; i++){
        for(int j=0; j<i; j++){
            if(arr[j]<arr[i]){
                if(sums[i]<=sums[j]+arr[i]){
                    sums[i] = sums[j]+arr[i];
                }
            }
        }
    }
    for(int a : sums){
        if(a>max)
            max=a;
    }
    return max;
}
  
  private static int max(int[] len) {
    int max=0,i;
    for(i=0; i<len.length; i++) {
      if(len[max]<=len[i])
        max=i;
    }
    return max;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine());
      arr = new int[n];
      String[] str = br.readLine().trim().split(" ");
      for(int i=0; i<n; i++)
        arr[i] = Integer.parseInt(str[i]);
      System.out.println(lis(n));
//      System.out.println(maxSum(arr, n));
    }
  }
}
