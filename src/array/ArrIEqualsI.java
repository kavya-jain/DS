package array;

import java.util.HashSet;
import java.util.Set;

public class ArrIEqualsI {

  public static void main(String[] args) {

    int[] array = {19, 7, 0, 3, 18, 15, 12, 6, 1, 8, 11, 9, 5, 13, 16, 2, 14, 17, 4, -1};

    Set<Integer> set = new HashSet<Integer>();

    for (int i : array) {
      set.add(i);
    }

    for (int i = 0; i < array.length; i++) {
      if (set.contains(i))
        array[i] = i;
      else
        array[i] = -1;
    }

    for (int i : array)
      System.out.println(i);

  }
}
