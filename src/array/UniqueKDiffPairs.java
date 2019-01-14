package array;

import java.util.HashSet;

public class UniqueKDiffPairs {
  
  private static int findPairs(int[] nums, int k) {
    if(k<0)               //absolute diff>=0
      return 0;
    
    int pairs = 0;
    HashSet<Integer> seen = new HashSet<>();
    HashSet<Integer> used = new HashSet<>();
    
    for(int i=0; i<nums.length; i++) {
      if(seen.contains(nums[i]-k) && !used.contains(nums[i]+nums[i]-k)) {
        //System.out.println(nums[i]+","+(nums[i]-k));
        pairs++;
        used.add(nums[i]+nums[i]-k);
      }
      
      if(seen.contains(nums[i]+k) && !used.contains(nums[i]+nums[i]+k)) {
        //System.out.println(nums[i]+","+(nums[i]-k));
        pairs++;
        used.add(nums[i]+nums[i]+k);
      }
      
      seen.add(nums[i]);
    }
    
    return pairs;
  }
  
  public static void main(String[] args) {
    
    int[] arr = {1,2,3,4,5,2};
    
    System.out.println(findPairs(arr,1));
    
  }

}
