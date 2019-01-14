package array;

public class Largest3 {

  public static void main(String args[]) {
    int[] a = { 3, 2, 1, 0 };

    int[] maxes = {Integer.MIN_VALUE,Integer.MIN_VALUE,Integer.MIN_VALUE};

    for (int i = 0; i < a.length; i++) {
      if (a[i] >= maxes[0]) {
        maxes[0] = a[i];
        continue;
      }

      if (a[i] >= maxes[1] && a[i] < maxes[0]) {
        maxes[1] = a[i];
        continue;
      }

      if (a[i] >= maxes[2] && a[i] < maxes[1] && a[i] < maxes[0]) {
        maxes[2] = a[i];
        continue;
      }

    }
    
    System.out.println(maxes[0] + ", " + maxes[1] + ", " + maxes[2]);

  }
}
