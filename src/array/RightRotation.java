package array;

public class RightRotation {

  public static void main(String[] args) {
    int[] array = { 21, 232, 33, 43 ,5 };
    int k = 2;
    
    rightRotaion(array, k);
    
  }

  private static void rightRotaion(int[] array, int k) {
    
    int[] temp = new int[k];
    for(int i=array.length-k, j=0; i<array.length; i++, j++)
      temp[j] = array[i];
    
    for(int i=array.length-k-1; i>=0; i--)
      array[i+k] = array[i];
    
    for(int i=0; i<temp.length; i++)
      array[i] = temp[i];
    
    for(int i : array)
      System.out.println(i);
      
  }
  
  
  
}
