package dp;

import java.io.*;

public class Knapsack01 {
  
  static int[] value, weights;
  static int n, w;
  
  public static int knapsack(){
      
      int [][] sack = new int[n+1][w+1];
      for(int i=0; i<=n; i++){
          for(int j=0; j<=w; j++){
              if(i==0||j==0)
                  sack[i][j] = 0;
              else if(weights[i-1]<=j) {
                  sack[i][j] = Math.max(value[i-1] + sack[i-1][j-weights[i-1]], sack[i-1][j]);
              }
              else
                  sack[i][j] = sack[i-1][j];
          }
      }
      return sack[n][w];
  }
  
public static void main (String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while(tc-->0){
        n = Integer.parseInt(br.readLine());
        w = Integer.parseInt(br.readLine());
        String[] val = br.readLine().trim().split(" ");
        String[] wt = br.readLine().trim().split(" ");
        value = new int[n];
        weights = new int[n];
        for(int i=0; i<n; i++){
            value[i] = Integer.parseInt(val[i]);
            weights[i] = Integer.parseInt(wt[i]);
        }
        System.out.println(knapsack());
    }
}

}
