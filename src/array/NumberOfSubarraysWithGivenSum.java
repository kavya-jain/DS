package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NumberOfSubarraysWithGivenSum {
  
  public static void main(String[] args) {
    int[] INPUT = {10, 2, -2, -20, 10};
    printSubarrays(INPUT, -10);
}

private static void printSubarrays(int[] input, int k) {
    HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
    List<Integer> initial = new ArrayList<Integer>();
    initial.add(-1);
    map.put(0, initial);
    int preSum = 0;

    // Loop across all elements of the array
    for(int i=0; i< input.length; i++) {
        preSum += input[i];
        if(map.containsKey(preSum - k)) {   // Subarray found 
            List<Integer> startIndices = map.get(preSum - k);
            for(int start : startIndices) {
                System.out.println("Start: "+ (start+1)+ "\tEnd: "+ i);
            }
        }

        List<Integer> newStart = new ArrayList<Integer>();
        if(map.containsKey(preSum)) { 
            newStart = map.get(preSum);
        }
        newStart.add(i);
        map.put(preSum, newStart);
    }
}

}
