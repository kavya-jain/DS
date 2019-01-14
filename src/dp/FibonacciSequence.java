package dp;

public class FibonacciSequence {
  
  public static int fib(int n, int[] memo) {
    if(memo[n]!=-1)
      return memo[n];
    int result;
    if(n==0 || n==1)
      result = 1;
    else {
      result = fib(n-1,memo)+fib(n-2,memo);
      memo[n]=result;
    }
    
    return result;
  }
  
  public static void main(String[] args) {
    int[] memo = new int[6];
    for(int i=0; i<6; i++)
      memo[i]=-1;
    System.out.println(fib(0,memo));
  }

}
