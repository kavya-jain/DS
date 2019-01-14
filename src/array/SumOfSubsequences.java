package array;

public class SumOfSubsequences {
  
  public static void main(String[] args) {
    
    int[] array = { 6, 8, 5 };
    int mulFactor = (int)Math.pow(2, array.length-1);
    
    System.out.println(subsequenceSum(array, 0, array.length-1)*mulFactor);
    
    
  }
  
  private static int subsequenceSum(int[] array, int start, int end) {
    
    if(start == end)
      return array[start];
    
    int mid = (start + end)/2;
    return subsequenceSum(array, start, mid) + subsequenceSum(array, mid+1, end);
  }

}
