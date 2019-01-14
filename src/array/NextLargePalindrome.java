package array;

import java.util.Arrays;

public class NextLargePalindrome {

  static int[] arr, palin;
  static int n;

  public static void makePalindrome() {
    palin = new int[n + 1];
    Arrays.fill(palin, -1);
    int i, j, nines = 0, mid = -1;
    if (n % 2 == 0) {
      i = n / 2;
      j = n / 2 + 1;
    } else {
      i = n / 2 - 1;
      j = n / 2 + 1;
      mid = n / 2;

    }
    for (int k = 0; j < n; j++) {
      if (arr[k] != 9)
        nines = 1;
    }
    if (nines == 0) {
      System.out.println((int) Math.pow(10, n) + 1);
      return;
    }
    while (i >= 0 && j<n) {
      if (arr[i] > arr[j])
        arr[j] = arr[i];
      else if (arr[i] < arr[j]) {
        arr[i + 1] += 1;
        if (arr[i + 1] == 10) {
          arr[i + 1] = 0;
          arr[i] = 1;
        }
        arr[j] = arr[i];
      }
      i--;
      j++;
    }
    for (int a : palin) {
      if (a != -1)
        System.out.print(a + " ");
    }

  }

  public static void main(String[] args) {
    arr = new int[] {1,2,3,4};
    n = arr.length;
    makePalindrome();
  }

}
