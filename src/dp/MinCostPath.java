package dp;

import java.util.Arrays;

public class MinCostPath {

  static int[][] arr;

  public static int cost(int m, int n) {
    int[] path = new int[m + n + 1];
    Arrays.fill(path, Integer.MIN_VALUE);
    path[0] = arr[0][0];
    int k = 1, i = 0, j = 0;

    while (i < m && j < n) {
      if (arr[i + 1][j] < arr[i][j + 1] && arr[i + 1][j] < arr[i + 1][j + 1]) {
        path[k] = path[k - 1] + arr[i + 1][j];
        i++;
        k++;
      } else if (arr[i][j + 1] < arr[i + 1][j + 1] && arr[i][j + 1] < arr[i + 1][j]) {
        path[k] = path[k - 1] + arr[i][j + 1];
        j++;
        k++;
      } else {
        path[k] = path[k - 1] + arr[i + 1][j + 1];
        i++;
        j++;
        k++;
      }

    }
    if (i != m) {
      while (i != m) {
        path[k] = path[k - 1] + arr[i + 1][n];
        i++;
        k++;
      }
    }
    if (j != n) {
      while (j != n) {
        path[k] = path[k - 1] + arr[m][j + 1];
        j++;
        k++;
      }
    }
    for (k = m + n; k >= 0; k--) {
      if (path[k] > 0)
        break;
    }

    return path[k];
  }

  public static void main(String[] args) {
    arr = new int[][] { { 3, 2, 8 }, { 1, 9, 7 }, { 0, 5, 2 }, { 6, 4, 3 } };
    System.out.println(cost(1, 1));
  }

}
