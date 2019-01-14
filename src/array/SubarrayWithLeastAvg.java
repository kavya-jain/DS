package array;

import java.io.*;

public class SubarrayWithLeastAvg {
  
  public static void main (String[] args) throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while(tc-->0){
        String[] nk = br.readLine().trim().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] arr = new int[n];
        String[] str = br.readLine().trim().split(" ");
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(str[i]);
       int s=0, e=k-1, prev_avg=0, avg=0;
       for(int i=0; i<k; i++){
           avg += arr[i]; 
       }
       prev_avg = avg;
       for(int i=k, j=0; i<n; i++, j++){
           avg = avg-arr[j]+arr[i];
           if(avg<prev_avg){
               prev_avg=avg;
               s=j+1;
               e=i;
           }
       }
       System.out.println(s+" "+e);
    }
}

}
