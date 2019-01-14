package array;

import java.util.*;

class KSamllest2DArray {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while (t-- > 0) {
      int[][] a = new int[21][21];
      int n = sc.nextInt();
      for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          a[i][j] = sc.nextInt();
        }
      }
      int k = sc.nextInt();
      GfG g = new GfG();
      g.kthSmallest(a, n, k);
    }
  }
}

/*
 * Please note that it's Function problem i.e. you need to write your solution
 * in the form of Function(s) only. Driver Code to call/invoke your function is
 * mentioned above.
 */

/* Complete the code */
class GfG {

  public static void kthSmallest(int[][] a, int n, int k) {

    int l = 0;
    int[] arr = new int[n * n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        arr[l++] = a[i][j];
      }
    }

    System.out.println(arr[kSmallest(arr, 0, n * n - 1, k)]);

  }

  private static int kSmallest(int[] arr, int low, int high, int k) {

    int pivot = findPivot(arr, low, high);

    if (pivot + 1 == k)
      return pivot;
    else if (pivot + 1 < k)
      return kSmallest(arr, pivot + 1, high, k);
    return kSmallest(arr, low, pivot - 1, k);

  }

  private static int findPivot(int[] arr, int low, int high) {

    int i = low - 1;
    int pivot = arr[high];
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }

    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;

    return i + 1;

  }

}