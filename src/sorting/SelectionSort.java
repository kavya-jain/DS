package sorting;

public class SelectionSort {
  
  public static void main(String[] args) {
    int[] array = new int[] {90,80,70,60,50,40,30,20,10,0};
    
    int j=0;
    int min=0;
    while(j<array.length) {
      for(int i=j+1; i<array.length; i++) {
        if(array[min]>array[i])
          min=i;
      }
      int temp = array[j];
      array[j]=array[min];
      array[min] = temp;
      j++;
      min=j;
    }
    for(int i : array)
      System.out.println(i+",");
  }

}
