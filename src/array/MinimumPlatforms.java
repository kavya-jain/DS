package array;

import java.io.*;

public class MinimumPlatforms {

  public static int[] arr, dep;

  public static void buildHeap(int[] array, int n) {
    for (int i = n / 2; i >= 0; i--) {
      heapify(array, n, i);
    }
  }

  public static void heapify(int[] array, int n, int i) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int max = i;

    if (left <= n && array[i] < array[left])
      max = left;
    if (right <= n && array[max] < array[right])
      max = right;
    if (max != i) {
      int temp = array[i];
      array[i] = array[max];
      array[max] = temp;
      heapify(array, n, max);
    }

  }

  public static int minPlatforms(int n) {
    int i = 0, j = 0, ctr = 0, max = 0;
    while (i <= n && j <= n) {
      if (arr[i] < dep[j]) {
        ctr++;
        if (max < ctr)
          max = ctr;
        i++;
      } else {
        ctr--;
        j++;
      }
    }
    return max;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine().trim());
      String[] arrStr = br.readLine().trim().split(" ");
      String[] depStr = br.readLine().trim().split(" ");
      arr = new int[n];
      dep = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = Integer.parseInt(arrStr[i]);
        dep[i] = Integer.parseInt(depStr[i]);
      }
      int temp;
      n--;
      int len = n;
      buildHeap(arr, n);
      for (int i = arr.length - 1; i >= 0; i--) {
        temp = arr[0];
        arr[0] = arr[n];
        arr[n] = temp;
        n--;
        heapify(arr, n, 0);
      }
      n = len;
      buildHeap(dep, n);
      for (int i = dep.length - 1; i >= 0; i--) {
        temp = dep[0];
        dep[0] = dep[n];
        dep[n] = temp;
        n--;
        heapify(dep, n, 0);
      }
      n=len;

//      for (int a : arr)
//        System.out.print(a + " ");
//      System.out.println();
//      for (int a : dep)
//        System.out.print(a + " ");
       System.out.println(minPlatforms(n));
    }
  }

}
