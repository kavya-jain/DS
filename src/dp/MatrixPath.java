package dp;

import java.io.*;
import java.util.ArrayList;

public class MatrixPath {

  public static int len(int[][] arr, int n) {

    ArrayList<Integer> maxPaths = new ArrayList<>();
    int maxSoFar;
    int i = 0, j = 0, k = 0;
    while (k < n) {
      i = 0;
      j = k;
      maxSoFar = arr[i][j];
      while (i < n - 1 && j < n) {
        if (j == 0) {
          if (arr[i + 1][j] > arr[i + 1][j + 1]) {
            maxSoFar += arr[i + 1][j];
            i++;
          } else {
            maxSoFar += arr[i + 1][j + 1];
            i++;
            j++;
          }
        } else if (j == n - 1) {
          if (arr[i + 1][j] > arr[i + 1][j - 1]) {
            maxSoFar += arr[i + 1][j];
            i++;
          } else {
            maxSoFar += arr[i + 1][j - 1];
            i++;
            j--;
          }
        } else {
          if (arr[i + 1][j] >= arr[i + 1][j - 1] && arr[i + 1][j] >= arr[i + 1][j + 1]) {
            maxSoFar += arr[i + 1][j];
            i++;
          }
          else if (arr[i + 1][j - 1] > arr[i + 1][j] && arr[i + 1][j - 1] >= arr[i + 1][j + 1]) {
            maxSoFar += arr[i + 1][j - 1];
            i++;
            j--;
          }
          else {
            maxSoFar += arr[i + 1][j + 1];
            i++;
            j++;
          }

        }

      }
      maxPaths.add(maxSoFar);
      k++;
    }
    int max = 0;
    for (int a : maxPaths) {
      if (max < a)
        max = a;
    }
    return max;

  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine());
      String[] str = br.readLine().trim().split(" ");
      int[][] arr = new int[n][n];
      int k = 0;
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          arr[i][j] = Integer.parseInt(str[k++]);
        }
      }
      System.out.println(len(arr, n));
    }
  }

}
