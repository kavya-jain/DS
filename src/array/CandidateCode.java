package array;

/* Read input from STDIN. Print your output to STDOUT*/

import java.io.*;
import java.util.*;

public class CandidateCode {

  public static void main(String args[]) throws Exception {

    Scanner scan = new Scanner(System.in);
    int wordLength = Integer.parseInt(scan.nextLine());
    String word = scan.nextLine();

    char[] wordArray = word.toCharArray();

    int count = findMinInsertionsDP(wordArray, word.length());
    System.out.println(count);

  }

  private static int minInsertions(char[] wordArray, int i, int j) {

    if (i > j) 
      return Integer.MAX_VALUE;
    if (i == j)
      return 0;
    if (j - 1 == 1)
      return (wordArray[i] == wordArray[j]) ? 0 : 1;
    if (wordArray[i] == wordArray[j]) {
      return minInsertions(wordArray, i + 1, j - 1);
    }
    return min(minInsertions(wordArray, i, j - 1), minInsertions(wordArray, i + 1, j)) + 1;
  }

  private static int min(int a, int b) {
    if (a < b)
      return a;
    else
      return b;
  }
  
  static int findMinInsertionsDP(char str[], int n) 
  { 
      int table[][] = new int[n][n]; 
      int l, h, gap; 

      for (gap = 1; gap < n; ++gap) 
      for (l = 0, h = gap; h < n; ++l, ++h) 
          table[l][h] = (str[l] == str[h])? 
                         table[l+1][h-1] : 
                        (Integer.min(table[l][h-1], 
                               table[l+1][h]) + 1); 

      return table[0][n-1]; 
  } 

}
