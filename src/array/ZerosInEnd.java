package array;

public class ZerosInEnd {

  public static void main(String[] args) {

    int[] array = { 1, 2, 0, 4, 3, 0, 5, 0 };
    int rotated = 0;

    for (int i = 0; i < array.length && (array.length-rotated !=i+1); i++) {
      if (array[i] == 0) {
        leftRotate(array, i, array.length - rotated-1);
        rotated++;
        i--;
      }
    }

    for (int a : array)
      System.out.println(a);
  }

  public static void leftRotate(int[] array, int index, int last) {
    int temp = array[index];
    for (int i = index + 1; i <= last; i++)
      array[i - 1] = array[i];
    array[last] = temp;
  }

}
