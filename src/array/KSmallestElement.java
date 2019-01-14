package array;

import java.util.*;
import java.lang.*;
import java.io.*;

class KSmallestElement {
    
    private static int kSmallest(int[] arr, int low, int high, int k) {
        
            int pivot = findPivot(arr, low, high);
            
            if(pivot+1 == k)
                return pivot;
            else if(pivot+1<k)
                return kSmallest(arr, pivot+1, high, k);
            return kSmallest(arr, low, pivot-1, k);
                
        
    }
    
    private static int findPivot(int[] arr, int low, int high) {
        
        int i=low-1;
        int pivot = arr[high];
        for(int j=low; j<high; j++) {
            if(arr[j]<pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        
        return i+1;
        
    }
    
  public static void main (String[] args) throws IOException {
      
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int tc = Integer.parseInt(br.readLine());
      
      while(tc-->0){
          int n = Integer.parseInt(br.readLine());
          String str = br.readLine();
          String[] strArr = str.trim().split(" ");
          int[] arr = new int[n];
          for(int i=0; i<n; i++)
              arr[i] = Integer.parseInt(strArr[i]);
          
          int k = Integer.parseInt(br.readLine());
          int pivot = kSmallest(arr, 0, n-1, k);
         // StringBuffer sb = new StringBuffer();
         // sb.append(pivot);
          System.out.println(arr[pivot]);
         
      }
      
  }
}