package array;

public class MaxHammingDistance {

  public static void main(String[] args) {

    int[] array = { 1, 0, 1, 0 };
    int k = array.length - 1;

    System.out.println(maxHammingDis(array, k));
  }

  private static int maxHammingDis(int[] array, int k) {

    int count = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[(i + k) % (array.length)] != array[i])
        count++;
    }

    return count;
  }

}
