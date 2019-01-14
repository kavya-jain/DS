package array;

public class SubsetsWithSum {
  
  public static void main(String[] args) {
    int[] arr = {2,4,6,10};
    int sum = 16,s = 0, count=0;
    
    for(int i=0; i< (1<<arr.length); i++) {
//      System.out.print("{");
      for(int j=0; j<arr.length; j++) {
        if((i & (1<<j))>0)
          s+=arr[j];
      }
//      System.out.println("}");
      if(sum == s)
        count++;
      s=0;
    }
    System.out.println(count);
  }

}

