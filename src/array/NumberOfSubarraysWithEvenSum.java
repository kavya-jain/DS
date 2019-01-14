package array;

import java.io.*;

public class NumberOfSubarraysWithEvenSum {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      String[] str = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++)
        arr[i] = Integer.parseInt(str[i]);

      int even = 1, odd = 0, sum = 0;
      for (int i = 0; i < n; i++) {
        sum += arr[i];
        if (sum % 2 == 0)
          even++;
        else
          odd++;
      }
      int count = (even * (even - 1) / 2) + (odd * (odd - 1) / 2);
      System.out.println(count);
    }
  }
}
