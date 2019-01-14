package dp;

public class SubsetsWithGivenSum2 {
  
  public static int subsets(int[] set, int n, int sum) {
    int[][] dp = new int[n+1][sum+1];
    
    dp[0][0] = 1;
    for(int i=0; i<=n; i++)
      dp[i][0] = 1;
    
    for(int j=1; j<=sum; j++)
      dp[0][j] = 0;
    
    
    for(int i=1; i<=n; i++) {
      for(int j=1; j<=sum; j++) {
        if(set[i-1] > j)
          dp[i][j] = dp[i-1][j];
        else
          dp[i][j] = dp[i-1][j] | dp[i-1][j-set[i-1]];
      }
    }
    
    return dp[n][sum];
  }
  
  public static void main(String[] args) {
    int[] set = {2,4,6,10};
    int n = set.length, sum = 5;
    System.out.println(subsets(set, n, sum));
  }

}
