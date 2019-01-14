package array;

import java.io.*;

public class RearrangeByGivenOrder {
  
  public static void main(String[] args) throws IOException{
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while(tc-->0) {
      int n = Integer.parseInt(br.readLine());
      int[] arr = new int[n];
      int[] index = new int[n];
      String str = br.readLine();
      String[] array = str.trim().split(" ");
      String ind = br.readLine();
      String[] indArray = ind.trim().split(" ");
      for(int i=0; i<n; i++) {
        arr[i] = Integer.parseInt(array[i]);
        index[i] = Integer.parseInt(indArray[i]);
      }
        
      for(int i=0; i<n; i++) {
        int temp = arr[i];
        arr[i] = arr[index[i]];
        arr[index[i]] = temp;
        
        temp = index[i];
        index[i] = index[index[i]];
        index[temp] = temp;
      }
      
      StringBuffer sb = new StringBuffer();
      for(int a : arr)
        sb.append(a+" ");
      System.out.println(sb);
      sb = new StringBuffer();
      for(int i : index)
        sb.append(i + " ");
      System.out.println(sb);
    }
  }

}
