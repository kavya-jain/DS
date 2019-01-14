package dp;

public class MinJumpsToEnd {
  
  public static void main(String[] args) {
    int[] arr = {1,4,3,7,1,2,6,7,6,10};
    /*O(n^2)
     * int i=0, j=0;
    int[] minJumps = new int[arr.length];
    minJumps[0]=0;
    for(i=1; i<arr.length; i++) {
      minJumps[i] = Integer.MAX_VALUE;
    }
    
    for(i=1; i<arr.length; i++) {
      for(j=0; j<i; j++) {
        if(i<=j+arr[j]) {
          minJumps[i] = Math.min(minJumps[i], minJumps[j]+1);
        }
      }
    }
    System.out.println(minJumps[arr.length-1]);*/
    
    //O(n)
    System.out.println(minJumps(arr));
  }

  private static int minJumps(int[] arr) {
    int maxReach = arr[0], steps = arr[0], jumps = 1;
    if(arr[0] == 0)
      return -1;
    if(arr.length == 1)
      return 0;
    
    for(int i=1; i<arr.length; i++) {
      maxReach = Math.max(maxReach, i+arr[i]);
      steps--;
      if(steps<=0) {
        jumps++;
        if(i>=maxReach) {
          jumps = -1;
          break;
        }
          
        steps = maxReach - i;
      }
    }
    return jumps;
  }

}
