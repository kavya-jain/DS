package array;

import java.io.*;

public class LongestPossibleNumber {

  public static boolean comp(int a, int b) {
    int ab = Integer.parseInt("" + a + "" + b);
    int ba = Integer.parseInt("" + b + "" + a);
    if (ab < ba)
      return false;
    return true;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      String str = br.readLine();
      String[] strArr = str.trim().split(" ");
      for (int i = 0; i < n; i++)
        arr[i] = Integer.parseInt(strArr[i]);

      int j = 0;
      for (int i = j + 1; i < n; i++) {
        if (comp(arr[i], arr[i - 1])) {
          int temp = arr[i];
          i--;
          while (i >= 0 && comp(temp, arr[i])) {
            arr[i + 1] = arr[i];
            i--;
          }
          arr[i + 1] = temp;
          j++;
          i = j;
        }
      }
      StringBuffer sb = new StringBuffer();
      for (int a : arr)
        sb.append(a);
      System.out.println(sb);
    }
  }

}
