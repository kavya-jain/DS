package array;

public class SumInRotatedArray {

  public static void main(String[] args) {
    int[] array = { 3, 4, 5, 6, 1, 2 };
    int sum = 8;

    System.out.println(isSum(array, sum));

  }

  private static String isSum(int[] array, int sum) {

    int pivot = findPivot(array);
//    String output;
    int i = pivot + 1, j = pivot;
    while (i != j) {
      if (i == array.length)
        i = 0;
      if (array[i] + array[j] == sum)
        break;
      
    //for all pairs
      /* output += "(" + array[i] + "," + array[j] + "), ";
       i++;
       j--;
       continue;*/

      if (array[i] + array[j] > sum)
        j--;

      if (array[i] + array[j] < sum)
        i++;
    }

    return "(" + array[i] + "," + array[j] + ")";     //output
  }

  private static int findPivot(int[] array) {

    int i;
    for (i = 0; i < array.length - 1; i++) {
      if (array[i] > array[i + 1])
        break;
    }
    return i;
  }

}
