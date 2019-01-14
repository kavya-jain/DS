
package sorting;

/**
 * The Class CocktailSort.
 * 
 * Bubble sort from both ends
 */
public class CocktailSort {
  
  public static void main(String[] args) {

    int[] array = new int[] {1,7,2,5,3,9,3,65,1};

    for(int i=0; i<array.length; i++) {
      for(int j=i; j<array.length-i-1; j++) {
        if(array[j]>array[j+1]) {
          int temp = array[j];
          array[j] = array[j+1];
          array[j+1] = temp;
        }
      }
      for(int k=array.length-i-2; k>i; k--) {
        if(array[k]<array[k-1]) {
          int temp = array[k];
          array[k] = array[k-1];
          array[k-1] = temp;
        }
      }
    }
    
    for(int i : array)
      System.out.println(i+",");
    
  }
  
}
