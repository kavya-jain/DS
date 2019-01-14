package array;

public class AlternatePositiveNegative {
  
  public static void main(String[] args) {
    
    int[] array = {-1,-2,-3,-4,1,2,3,4};
    int lastNeg = partition(array,0,array.length-1);
    
    int i=0, j=lastNeg+1;
    while(i<j && j< array.length && array[i]<0) {
      int temp = array[i];
      array[i]=array[j];
      array[j]=temp;
      i+=2;
      j++;
      
    }
    
    for(int a:array)
      System.out.println(a);
  }

  private static int partition(int[] arr, int low, int high) {
    
    int pivot = 0;
    int i=-1;
    int j = 0;
    
    for(j=0; j<arr.length; j++) {
      if(arr[j]<=pivot) {
        i++;
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
      }
    }
    return i;
  }

}
