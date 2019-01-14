package dp;

import java.io.*;

public class MaxSumBitonicSeq {

  static int[] lis, lds, arr, seq;
  static int n;

  public static void maxSumlis() {
    lis = new int[n];
    seq = new int[n];

    for (int i = 0; i < n; i++)
      lis[i] = arr[i];

    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (arr[i] > arr[j]) {
          if (lis[i] < lis[j] + arr[i]) {
            lis[i] = lis[j] + arr[i];
            seq[i] = j;
          }
        }
      }
    }
  }

  public static void maxSumlds() {
    lds = new int[n];

    for (int i = 0; i < n; i++)
      lds[i] = arr[i];

    for (int i = n - 2; i >= 0; i--) {
      for (int j = n - 1; j > i; j--) {
        if (arr[i] > arr[j]) {
          if (lds[i] < lds[j] + arr[i]) {
            lds[i] = lds[j] + arr[i];
          }
        }
      }
    }
  }

  public static int maxSumBitonic() {
    int max = 0, max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
    for (int i = 0; i < n; i++) {
      if (lis[i] > lis[max])
        max = i;
    }

    max1 = lis[max] - arr[max];

    for (int i = 0; i < n; i++) {
      if (lds[i] > max2)
        max2 = lds[i];
    }

    return max1 + max2;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      n = Integer.parseInt(br.readLine());
      String[] str = br.readLine().trim().split(" ");
      arr = new int[n];
      for (int i = 0; i < n; i++)
        arr[i] = Integer.parseInt(str[i]);
      maxSumlis();
      maxSumlds();
      System.out.println(maxSumBitonic());
    }
  }
}
