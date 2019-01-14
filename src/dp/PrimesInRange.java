package dp;

import java.io.*;

public class PrimesInRange {

  static int n;
  static int[] seive;

  public static void SOE() {
    seive = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      seive[i] = 1;
    }

    for (int p = 2; p * p <= n; p++) {
      if (seive[p] == 1) {
        for (int i = p * 2; i <= n; i += p) {
          seive[i] = 0;
        }
      }
    }
    for (int i = 2; i <= n; i++) {
      if (seive[i] == 1)
        System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      n = Integer.parseInt(br.readLine());
      SOE();
    }
  }

}
