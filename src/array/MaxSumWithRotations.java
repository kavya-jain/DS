package array;

public class MaxSumWithRotations {
  
  public static void main(String[] args) {
    
    int[] array = { 8, 3, 1, 2 };
    
    int sum=0, currSum=0;
    for(int i=0; i<array.length; i++) {
      sum+=array[i];              //sum
      currSum+=i*array[i];        //R0
    }
      
    
    int maxSum = sum;
    for(int i=1; i<array.length; i++) {
      currSum = sum + currSum - array.length * array[array.length - i];
      if(currSum > maxSum)
        maxSum = currSum;
    }
    
    System.out.println(maxSum);
  }
  
}
