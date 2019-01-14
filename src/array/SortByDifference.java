package array;

import java.io.*;

public class SortByDifference {

  public static int compared(int a, int b, int k) {
    if (Math.abs(a - k) > Math.abs(b - k))
      return 1;
    if (Math.abs(a - k) < Math.abs(b - k))
      return -1;
    return 0;
  }

  public static void cocktailSort(int[] array, int diff) {
    for (int i = 0; i < array.length; i++) {
      for (int j = i; j < array.length - i - 1; j++) {
        if (compared(array[j], array[j + 1], diff) == 1) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
        }
      }
      for (int k = array.length - i - 2; k > i; k--) {
        if (compared(array[k], array[k - 1], diff) == -1) {
          int temp = array[k];
          array[k] = array[k - 1];
          array[k - 1] = temp;
        }
      }
    }
  }

  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      String[] nk = br.readLine().trim().split(" ");
      int n = Integer.parseInt(nk[0]);
      int k = Integer.parseInt(nk[1]);
      int[] arr = new int[n];
      String[] strArr = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++)
        arr[i] = Integer.parseInt(strArr[i]);

      cocktailSort(arr, k);

      for (int a : arr)
        System.out.print(a + " ");
      System.out.println();

    }

  }

}
