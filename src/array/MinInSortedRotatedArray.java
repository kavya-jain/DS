package array;

public class MinInSortedRotatedArray {

  public static void main(String[] args) {

    int[] array = { 20,30,40,50 };
    int mid;
    mid = (0 + array.length - 1) / 2;
    if (array[mid] > array[array.length - 1])
      System.out.println(binarySearch(array, mid + 1, array.length - 1));
    else
      System.out.println(binarySearch(array, 0, mid));
  }

  private static int binarySearch(int[] array, int i, int j) {

    if (i == j)
      return array[i];

    int mid = (i + j) / 2;
    if (array[mid] < array[j])
      return binarySearch(array, i, mid);
    return binarySearch(array, mid + 1, j);
  }

}
