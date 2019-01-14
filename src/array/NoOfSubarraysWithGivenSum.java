package array;

public class NoOfSubarraysWithGivenSum {

  public static void findSubarray(int[] A, int sum) {
    int windowSum = 0, pairs = 0;

    int low = 0, high = 0;

    for (low = 0; low < A.length; low++) {
      while (windowSum < sum && high < A.length) {
        windowSum += A[high];
        high++;
      }

      if (windowSum == sum) {
        System.out.printf(low + 1 + " " + high);
        System.out.println();
        pairs++;
      }

      if(windowSum>sum)
        windowSum -= A[low];
    }
    System.out.println(pairs);
    if (windowSum != sum)
      System.out.println(-1);
  }

  public static void main(String[] args) {
      int[] arr = {10, 2, -2, -20, 10};

      findSubarray(arr, 10);

  }
}