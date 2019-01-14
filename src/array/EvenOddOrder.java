package array;

public class EvenOddOrder {

  public static void main(String[] args) {

    int[] array = { 1, 2, 1, 4, 5, 6, 8, 8 };
    int[] sorted = {1,2,3,4,5,6,7,8}; 
    int j=array.length-1;
    if(array.length % 2 == 0) {
      array[j] = sorted [j];
      j--;
    }
    int temp = j;
    for(int i=0; j>=0; i++) {
      array[j] = sorted[i];
      j-=2;
    }
      
    j=temp-1;
    for (int i = sorted.length - 2; j >= 1; i--) {
      array[j] = sorted[i];
      j-=2;
    }
    
    for(int i : array)
      System.out.println(i);
      
  }
}