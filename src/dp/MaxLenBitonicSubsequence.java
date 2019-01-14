package dp;

import java.util.*;
import java.io.*;

public class MaxLenBitonicSubsequence {

  public static int[] lis, lds, arr;

  //  construct from left to right
  public static void lisTable(int[] arr, int n) {
    lis = new int[n];
    Arrays.fill(lis, 1);

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          if (lis[i] <= lis[j] + 1)
            lis[i] = lis[j] + 1;
        }
      }
    }
  }

  //construct from right to left
  public static void ldsTable(int[] arr, int n) {
    lds = new int[n];
    Arrays.fill(lds, 1);

    for (int i = n - 2; i >= 0; i--) {
      for (int j = n - 1; j > i; j--) {
        if (arr[i] > arr[j]) {
          if (lds[i] <= lds[j] + 1)
            lds[i] = lds[j] + 1;
        }
      }
    }
  }

  public static int maxLen(int[] lis, int[] lds, int n) {
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (max < (lis[i] + lds[i] - 1))
        max = lis[i] + lds[i] - 1;
    }
    return max;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine());
      arr = new int[n];
      String[] str = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++)
        arr[i] = Integer.parseInt(str[i]);
      lisTable(arr, n);
      ldsTable(arr, n);
      System.out.println(maxLen(lis, lds, n));
    }
  }
}