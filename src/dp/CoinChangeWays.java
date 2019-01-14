/*
 * Ways for coins used to get the total
 */
package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinChangeWays {
  
  public static int change(int[] denom, int total) {
    
    int[] mem = new int[total+1];
    mem[0] = 1;
    for(int j=0; j<denom.length; j++) {
      for(int i=1; i<=total; i++) {
        if(i>=denom[j]) {
          mem[i] = mem[i] + mem[i-denom[j]];
        }
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
      System.out.println(change(denom, total));
    }
  }

}
