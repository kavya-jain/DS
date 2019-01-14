package array;

public class KMaxSumNonOverlappingSubarray {
  
  private static void kMaxSums(int[] arr, int n, int k) {
    int max_so_far;
    int max_end, start, end, s;
    
    for(int c=0; c<k; c++) {
      
      max_so_far = Integer.MIN_VALUE;
      max_end = 0; 
      start = 0; 
      end = 0;
      s = 0;
      for(int i=0; i<n; i++) {
        
        max_end = max_end + arr[i];
        if(max_so_far<max_end) {
          max_so_far = max_end;
          end = i;
          start = s;
        }
           
        if(max_end<0) {
          max_end=0;
          s = i+1;
          
        }
        
      }
      System.out.println(c+1 +"sum = "+max_so_far+": "+start+","+end);
      
      for(int i=start; i<=end; i++) {
        arr[i]=Integer.MIN_VALUE;
      }
    }
    
  }
  
  public static void main(String[] args) {
    
    int[] arr = {4, 1, 1, -1, -3, -5, 6, 2, -6, -2};
    kMaxSums(arr, 10, 3);
    
  }

}
