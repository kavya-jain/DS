package array;

public class TwoNumWithOddOccurence {
  
  static int[] arr;
  static int n;
  
  public static void oddOccurence() {
    int xor=0, x=0, y=0, set=0;
    
    for(int i=0; i<n; i++) {
      xor ^= arr[i];
    }
    
    set = xor^(xor&(xor-1));
    
    for(int i=0; i<n; i++) {
      if((arr[i] & set)==0)
        y^=arr[i];
      else
        x^=arr[i];
    }
    System.out.println("x = "+x+" y = "+y);
  }
  
  public static void main(String[] args) {
    n=8;
    arr = new int[] {4, 2, 4, 5, 2, 5, 3, 1};
    oddOccurence();
  }

}
