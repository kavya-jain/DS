package array;

public class KadaneAlgorithm {
  
  public static void main (String[] args) 
  { 
      int [] a = {-2, -3, 4, -1, -2, 1, 5, -3}; 
      System.out.println("Maximum contiguous sum is " + 
                                     maxSubArraySum(a)); 
  } 

  static int maxSubArraySum(int a[]) 
  { 
      int size = a.length; 
      int max_so_far = a[0], max_ending_here = a[0]; 

      for (int i = 1; i < size; i++) 
      { 
          max_ending_here = Math.max(a[i], max_ending_here + a[i]); 
          if (max_so_far < max_ending_here) 
              max_so_far = max_ending_here; 
      } 
      return max_so_far; 
  } 

}
