package dp;

import java.io.*;

public class GoldMine {

  public static int max(int i, int j, int k) {
    int m = i;
    if (m < j)
      m = j;
    if (m < k)
      m = k;
    return m;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      String[] rc = br.readLine().trim().split(" ");
      int row = Integer.parseInt(rc[0]);
      int col = Integer.parseInt(rc[1]);
      String[] str = br.readLine().trim().split(" ");
      int[][] arr = new int[row][col];
      int[][] gold = new int[row][col];
      int k = 0;
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          arr[i][j] = Integer.parseInt(str[k++]);
          gold[i][j] = 0;
        }
      }
      int r, u, d;
      for (int j = col - 1; j >= 0; j--) {
        for (int i = 0; i < row; i++) {
          r = (j == col - 1) ? 0 : gold[i][j + 1];
          u = ((j == col - 1) || (i == 0)) ? 0 : gold[i - 1][j + 1];
          d = ((j == col - 1) || (i == row - 1)) ? 0 : gold[i + 1][j + 1];

          gold[i][j] = arr[i][j] + max(r, u, d);
        }
      }
      StringBuffer sb = new StringBuffer();
      sb.append("{(");
      int h, v;
      for (int j = 0; j < col; j++) {
        h = 0;
        v = 0;
        int max = 0;
        for (int i = 0; i < row; i++) {
          if (max < gold[i][j]) {
            max = gold[i][j];
            h = i;
            v = j;
          }
        }
        sb.append(h + "," + v + ")->(");
      }
      sb.append("}");
      sb.delete(sb.length() - 4, sb.length() - 1);
      System.out.println(sb);
    }
  }

}
