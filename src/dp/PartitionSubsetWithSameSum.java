package dp;

import java.util.*;

public class PartitionSubsetWithSameSum {

  public static boolean solve(int[] arr, int n) {
            
        int totalSum = 0;
        for(int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
        
        // if total sum is odd then this set of numbers
        // can not be divided into 2 subsets
        if(totalSum % 2 == 1) 
            return false;
        
        int requiredSum = totalSum /2;
        
        // this array is going to keep track of what
        // are all possible sums
        boolean[] possibleSums = new boolean[totalSum+1];
        possibleSums[0] = true;
        
        // consider each element one by one
        // update all possible sums if I include 
        // this element
        /*
        
        // in this there is a problem, 
        // I am updating possible sums by starting from
        // lower sum values, so when I check for higher
        // sum values I end up using lower sum values which
        // have been updated by this number only,
        
        for(int i = 0; i < n; i++) {
            int el = arr[i];
            for(int j = arr[i]; j <= totalSum; j++) {
                if(possibleSums[j - arr[i]])
                    possibleSums[j] = true;
            }
        }
        */
        
        // to solve problem faced in previous way
        // I am starting from higher sum values
        for(int i = 0; i < n; i++) {
            for(int j = requiredSum - arr[i]; j >= 0; j--) {
                if(possibleSums[j])
                    possibleSums[j + arr[i]] = true;
            }
        }
        
        
        return possibleSums[requiredSum];
    }
    
  public static void main (String[] args) {
    
    Scanner in = new Scanner(System.in);
    
    int testcases = in.nextInt();
    for(int i = 0; i < testcases; i++) {
            
            // inputs
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) {
                arr[j] = in.nextInt();
            }
            
            // solve
            boolean ans = solve(arr, n);
            if(ans)
                System.out.println("YES");
            else
                System.out.println("NO");
    }
    in.close();
  }
}