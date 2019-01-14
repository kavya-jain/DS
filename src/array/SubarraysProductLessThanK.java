package array;

public class SubarraysProductLessThanK {

  public static void main(String[] args) {

    int s = 0, e = 0, res = 0, p = 1, k = 12, len;
    int[] arr = { 1, 2, 3, 4 };

    for (e = 0; e < arr.length; e++) {
      p = p * arr[e];

      while (s < e && p >= k) {
        p /= arr[s];
        s++;
      }

      if (p < k) {
        System.out.println(arr[s] + "," + arr[e]);
        len = e - s + 1;
        res += len;
      }
    }

    
  }

}
