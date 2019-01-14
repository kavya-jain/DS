/* Length of LCS and printing it */

package dp;

public class LongestCommonSubsequence {
  
  static int[][] lcs;
  
  public static int makeTable(char[] str1, int m, char[] str2, int n) {
    lcs = new int[m+1][n+1];
    
    for(int i=0; i<=m; i++) {
      for(int j=0; j<=n; j++) {
        if(i==0||j==0)
          lcs[i][j]=0;
        
        else if(str1[i-1] == str2[j-1])
          lcs[i][j] = 1+lcs[i-1][j-1];
        
        else
          lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
      }
    }
    return lcs[m][n];
  }
  
  public static void print(char[] arr1, int m, char[] arr2, int n, int len) {
    char[] subseq = new char[len];
    int i=m, j=n, k=len-1;
    while(i>0 && j>0) {
      if(arr1[i-1] == arr2[j-1]) {
        subseq[k--] = arr1[i-1];
        i--;
        j--;
      }
      
      else if(lcs[i-1][j]>lcs[i][j-1])
        i--;
      else
        j--;
    }
    
    for(i=0; i<len; i++)
      System.out.print(subseq[i]);
  }
  
  public static void main(String[] args) {
    String str1 = "AGGTAB", str2 = "GXTXAYB";
    char[] arr1 = str1.toCharArray(), arr2 = str2.toCharArray();
    int m = str1.length(), n=str2.length();
    int len = makeTable(arr1, m, arr2, n);
    print(arr1, m, arr2, n, len);
  }
}
