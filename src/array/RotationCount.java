package array;

public class RotationCount {

  public static void main(String[] args) {
    int[] array = { 2,3,4,5,6,1 };
    
    int i, flag=0;
    for(i=0; i<array.length-1; i++) {           //O(n); find min by binary search givesO(logn)
      if(array[i] > array[i+1]) {
        flag =1;
        break;
      }
    }
    
    System.out.println(flag==0?0:i+1);
  }
}
