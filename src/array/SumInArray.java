package array;

public class SumInArray {

  public static void main(String[] args) {
    int[] array = { 1, 2, 3, 4, 5, 6 };
    int sum = 8;

    System.out.println(isSum(array, sum));

  }

  private static String isSum(int[] array, int sum) {

    int i = 0, j = array.length - 1;
    while (i != j) {
      if (array[i] + array[j] == sum)
        break;

      if (array[i] + array[j] > sum)
        j--;

      if (array[i] + array[j] < sum)
        i++;
    }

    return "(" + array[i] + "," + array[j] + ")";
  }

}
