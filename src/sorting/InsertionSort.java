package sorting;

public class InsertionSort {
  
  private int[] array;
  
  public InsertionSort(int[] array) {
    this.array = array;
  }
  
  public void insertionSort() {
    int sorted = 0;
    int temp = 0;

    for (int i = 1; i < array.length; i++) {
      temp = array[i];
      int j = i;
      while (sorted >= 0 && temp < array[sorted]) {
        array[i] = array[sorted];
        i--;
        sorted--;
      }
      array[i] = temp;
      i = j;
      sorted = i;
    }
    for (int i : array)
      System.out.println(i + ",");
  }

  public static void main(String[] args) {
    InsertionSort array = new InsertionSort(new int[] {88, 57, 44, 92, 28, 66, 60, 37, 33, 52, 38, 29, 76, 8, 75 });
    array.insertionSort();
    
    System.out.println(Integer.parseInt(""+1+""+2));
    
  }
}
