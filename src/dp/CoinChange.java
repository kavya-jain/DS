/*
 * Minimum coins used to get the total
 */
package dp;

import java.io.*;

public class CoinChange {

  public static int min(int a, int b) {
    return (a < b) ? a : b;
  }

  public static int change(int total, int[] denom) {

    int[] mem = new int[total + 1];
    mem[0] = 0;
    for (int i = 1; i < mem.length; i++)
      mem[i] = Integer.MAX_VALUE-1;

    for (int i = 0; i < denom.length; i++) {
      for (int j = 0; j < mem.length; j++) {
        if(j>=denom[i])
          mem[j] = min(mem[j], 1 + mem[j - denom[i]]);
      }
        
    }

    return mem[total];
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      int len = Integer.parseInt(br.readLine());
      String[] str = br.readLine().trim().split(" ");
      int total = Integer.parseInt(br.readLine());
      int[] denom = new int[len];
      for (int i = 0; i < len; i++)
        denom[i] = Integer.parseInt(str[i]);
      System.out.println(change(total, denom));
    }
  }

}
