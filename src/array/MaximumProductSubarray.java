package array;

public class MaximumProductSubarray {

  public static int max(int a, int b, int c) {
    int maximum = a;
    if (b > maximum)
      maximum = b;
    if (c > maximum)
      maximum = c;
    return maximum;
  }

  public static void main(String[] args) {

    int[] arr = { -1, 2, 3, -2, 4 };
    int curr_max = arr[0], curr_min = arr[0], prev_max = arr[0], prev_min = arr[0], ans = arr[0];

    for (int i = 0; i < arr.length; i++) {
      curr_max = max(prev_max * arr[i], prev_min * arr[i], arr[i]);
      curr_min = -max(-prev_max * arr[i], -prev_min * arr[i], -arr[i]);
      ans = Math.max(ans, curr_max);
      prev_max = curr_max;
      prev_min = curr_min;
    }
    
    System.out.println(ans);

  }

}
