package array;

public class QuickRotations {

  public static void main(String[] args) {

    int[] array = { 1, 3, 5, 7, 9 };
    int k = 6;
    
    int noOfRotations = k % array.length;
    leftRotation(array, noOfRotations);

  }

  private static void leftRotation(int[] array, int noOfRotations) {
    
    int[] temp = new int[noOfRotations];
    for(int i=0; i<noOfRotations; i++) {
      temp[i] = array[i];
    }
    
    for(int i=0; i<array.length-noOfRotations; i++) {
      array[i] = array[i+noOfRotations];
    }
    
    for(int i=0; i<temp.length; i++) {
      array[array.length-noOfRotations+i] = temp[i];
    }
    
    for(int i : array)
      System.out.println(i);
    
  }

}
