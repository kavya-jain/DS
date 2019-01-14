package array;

import java.util.*;

public class LargerEvenSmallerOdds {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);
    int tc = scan.nextInt();
    while (tc-- > 0) {
      int n = scan.nextInt();
      int[] arr = new int[n];
      int[] sorted = new int[n];  
      for (int i = 0; i < n; i++) {
        arr[i] = scan.nextInt();
        sorted[i]=arr[i];
      }
      int i, j;
      Arrays.sort(sorted);
      

      int odds = (n % 2 == 0) ? (n / 2) : ((n / 2) + 1);
      for (i = 0, j = 0; j < odds; i += 2) {
        arr[i] = sorted[j++];
      }
      for (i = 1, j = n-1; j >=odds ; i += 2) {
        arr[i] = sorted[j--];
      }

      for (int a : arr)
        System.out.print(a + " ");
      System.out.println();
    }

  }

}
