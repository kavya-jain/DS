/*
 * Max profit achieved by cutting the rod in smaller pieces
 */

package dp;

public class RodCutting {

  public static int maxProfit(int[] profit, int len) {

    int[] dp = new int[len + 1];
    dp[0] = 0;

    for (int i = 1; i <= len; i++)
      dp[i] = Integer.MIN_VALUE;

    for (int i = 1; i <= len; i++) {
      for (int j = i; j <= len; j++) {
        dp[j] = Math.max(dp[j], profit[i - 1] + dp[j - i]);
      }
    }

    return dp[len];

  }

  public static void main(String[] args) {
    int[] profit = { 3, 5, 8, 9, 10, 17, 17, 20 };
    int len = 8;
    System.out.println(maxProfit(profit, len));
  }

}
