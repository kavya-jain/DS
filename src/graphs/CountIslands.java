package graphs;

import java.util.*;
import java.io.*;

class Pair {
  int x, y;

  Pair(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

class CountIslands {

  public static void BFS(char[][] mat, boolean[][] processed, int i, int j) {
    Queue<Pair> q = new ArrayDeque<>();
    q.add(new Pair(i, j));

    processed[i][j] = true;
    while (!q.isEmpty()) {
      int x = q.peek().x;
      int y = q.peek().y;
      q.poll();
      if (isSafe(mat, processed, x + 1, y)) {
        processed[x + 1][y] = true;
        q.add(new Pair(x + 1, y));
      }
      if (isSafe(mat, processed, x - 1, y)) {
        processed[x - 1][y] = true;
        q.add(new Pair(x - 1, y));
      }
      if (isSafe(mat, processed, x, y + 1)) {
        processed[x][y + 1] = true;
        q.add(new Pair(x, y + 1));
      }
      if (isSafe(mat, processed, x, y - 1)) {
        processed[x][y - 1] = true;
        q.add(new Pair(x, y - 1));
      }
    }
  }

  public static boolean isSafe(char[][] matrix, boolean[][] processed, int i, int j) {
    return (i >= 0) && (i < processed.length) && (j >= 0) && (j < processed[0].length)
        && (matrix[i][j] == 'X' && !processed[i][j]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      String[] nm = br.readLine().trim().split(" ");
      int n = Integer.parseInt(nm[0]);
      int m = Integer.parseInt(nm[1]);
      char[][] matrix = new char[n][m];
      String[] str = br.readLine().trim().split(" ");
      for (int i = 0; i < n; i++) {
        char[] charArray = str[i].toCharArray();
        for (int j = 0; j < m; j++) {
          matrix[i][j] = charArray[j];
        }

      }

      boolean[][] processed = new boolean[n][m];
      int count = 0;

      for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          if (matrix[i][j] == 'X' && !processed[i][j]) {
            BFS(matrix, processed, i, j);
            count++;
          }
        }
      }
      System.out.println(count);

    }
  }
}
