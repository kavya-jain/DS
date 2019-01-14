package dp;

import java.io.*;

public class FriendsPairing {
  
  public static long friendPairs(int n) {
    
    final long mod = 1000000007;
    
    long[] mem = new long[n+1];

    for(int i=0; i<=n; i++) {
      if(i<=2)
        mem[i] = i;
      
      else
        mem[i] = (mem[i-1] + ((i-1)*mem[i-2])%mod)%mod;
    }
    
    return mem[n];
  }

  public static void main(String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      int n = Integer.parseInt(br.readLine());
      System.out.println(friendPairs(n));
    }
  }
}
