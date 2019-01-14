/* 1, 2, 2, 3, 3, 4, 4, 4, 5, 5, 5, …… */

package dp;

public class GolombSequence {
  
  public static int seq(int n) {
    int[] arr = new int[n+1];
    
    arr[0]=0;
    arr[1]=1;
    int j=1;
    
    for(int i=2; i<=n; i++) {
      j=i;
      while(j>0) {
        arr[i+j-1] = i;
      }
    }
    return arr[n];
  }
  
}
