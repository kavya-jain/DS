/*
 * At most two consecutive fences can have same color. Find the number of ways to color n fences with k colors.
 */
package dp;

public class FencePainting {

  public static long ways(int n, int k) {
    long diff, same, total;
    if(n==0)
      return 0;
    
    same = 0; diff = k; total = k;
    for(int i=2; i<=n; i++) {
      same = diff;
      diff = (total * (k-1)) % 1000000007;
      total = (same + diff) % 1000000007;
    }
    
    return total;
  }
  
  public static void main(String[] args) {
    int n = 2, k = 4;
    System.out.println(ways(n,k));
  }
}
