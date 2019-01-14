package sorting;

public class QuickSort {

  public static int partition(int[] array, int low, int high) {

    int pivot = array[high];

    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (array[j] <= pivot) {
        i++;
        swap(array, j, i);
      }
    }
    swap(array, i + 1, high);
    return i + 1;
  }

  private static void swap(int[] array, int i, int j) {
    int temp = array[i];
    array[i] = array[j];
    array[j] = temp;
  }

  public static void quickSort(int[] array, int low, int high) {

    if (low < high) {
      int part = partition(array, low, high);

      quickSort(array, low, part - 1);
      quickSort(array, part + 1, high);
    }
  }

  public static void main(String[] args) {
    int[] array = { 10, 80, 30, 90, 40, 50, 70 };
    quickSort(array, 0, array.length-1);
    for(int i : array)
      System.out.println(i);

  }

}
