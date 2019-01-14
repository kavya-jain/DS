package dp;

import java.io.*;

public class EditDistance {
  
  static int[][] dis;
  
  public static int makeTable(char[] str1, int m, char[] str2, int n) {
    dis = new int[m+1][n+1];
    for(int i=0; i<=m; i++) {
      for(int j=0; j<=n; j++) {
        if(i==0)
          dis[i][j]=j;
        else if(j==0)
          dis[i][j]=i;
        
        else if(str1[i-1] == str2[j-1])
          dis[i][j] = dis[i-1][j-1];
        
        else
          dis[i][j] = 1+Math.min(Math.min(dis[i-1][j], dis[i][j-1]), dis[i-1][j-1]);
      }
    }
    return dis[m][n];
  }
  
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      String[] st = br.readLine().trim().split(" ");
      String[] strings = br.readLine().trim().split(" ");
      String src = strings[0];
      String target = strings[1];
      int s = Integer.parseInt(st[0]);
      int t = Integer.parseInt(st[1]);
      System.out.println(makeTable(src.toCharArray(), s, target.toCharArray(), t));
    }
  }

}
