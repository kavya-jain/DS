package array;

public class MinDistanceBtwNumbers {
  
  public static void main(String[] args) {
    int[] a = { 86, 39, 86, 66, 84, 66, 62 };
    int x = 86, y = 66;
    System.out.println(minDist(a, a.length, x, y));
  }

  static int minDist(int arr[], int n, int x, int y) {
    int i = 0, xi = 0, yi = 0, prev_dis = Integer.MAX_VALUE, ctrx = 0, ctry = 0,
        curr_dis = 0;
    while (i < n) {
      if (arr[i] == x) {
        xi = i;
        ctrx++;
      }

      if (arr[i] == y) {
        yi = i;
        ctry++;
      }

      if ((ctrx != 0 && ctry != 0)) {
        curr_dis = Math.abs(xi - yi);
        prev_dis = prev_dis > curr_dis ? curr_dis : prev_dis;
      }
      i++;

    }
    if (ctrx == 0 || ctry == 0)
      return -1;
    return prev_dis;
  }
}
