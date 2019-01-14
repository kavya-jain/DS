package dp;

import java.io.*;

public class LongestPalindromicSubsequence {

  public static int[][] lcs;
  public static String str1, str2;
  public static char[] arr1, arr2;
  public static int n;

  public static int build() {
    lcs = new int[n + 1][n + 1];
    for (int i = 0; i <= n; i++) {
      for (int j = 0; j <= n; j++) {
        if (i == 0 || j == 0)
          lcs[i][j] = 0;

        else if (arr1[i - 1] == arr2[j - 1])
          lcs[i][j] = 1 + lcs[i - 1][j - 1];
        else {
          lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
        }
      }
    }

    return lcs[n][n];
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      str1 = br.readLine();
      n = str1.length();
      arr1 = new char[n];
      arr2 = new char[n];
      arr1 = str1.toCharArray();
      for (int i = 0; i < n; i++)
        arr2[i] = arr1[n - i - 1];
      System.out.println(build());
    }
  }

}
