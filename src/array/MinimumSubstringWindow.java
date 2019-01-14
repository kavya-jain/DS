package array;

import java.util.*;

public class MinimumSubstringWindow {

  public static void main(String[] args) {
    char[] s = { 'a', 'c', 'b', 'd', 'n', 'r', 'a', 'c', 'b', 'n' };
    char[] t = { 'a', 'b', 'n' };

    Map<Character, Integer> counts = new HashMap<>();
    for (char c : t)
      counts.merge(c, 1, Integer::sum);

    int i = 0, j = 0, l = 0, r = 0, missing = t.length;
    while (r < s.length) {
      if (counts.containsKey(s[r])) {
        if (counts.get(s[r]) > 0)
          missing -= 1;
        counts.put(s[r], counts.get(s[r]) - 1);
      }
      r++;
      while (missing == 0) {
        if (j == 0 || r - l < j - i) {
          i = l;
          j = r;
        }
        if (counts.containsKey(s[l])) {
          counts.put(s[l], counts.get(s[l]) + 1);
          if (counts.get(s[l]) > 0)
            missing += 1;
        }
        l++;

      }
    }

    System.out.println(i + "," + (j+1));

  }

}
