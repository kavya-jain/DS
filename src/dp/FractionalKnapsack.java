package dp;

import java.io.*;
import java.text.DecimalFormat;

class Item {
  int val;
  int wt;
  double cost;

  Item(int val, int wt) {
    this.val = val;
    this.wt = wt;
    cost = new Double(val / wt);
  }
}

public class FractionalKnapsack {
  static int[] value, weight;
  static Item[] list;
  static int n, w;

  public static void heapsort() {
    for (int i = n / 2; i >= 0; i--) {
      heapify(i);
    }
  }

  public static void heapify(int i) {
    int left = 2 * i + 1;
    int right = 2 * i + 2, max = i;
    Item temp;
    if (left < n && list[left].cost < list[max].cost) {
      max = left;
    }
    if (right < n && list[right].cost < list[max].cost) {
      max = right;
    }
    if (max != i) {
      temp = list[i];
      list[i] = list[max];
      list[max] = temp;
      heapify(max);
    }
  }

  public static double knapsack() {
    double profit = 0;
    for (int i = 0; i < list.length; i++) {
      if (list[i].wt <= w) {
        profit += list[i].val;
        w -= list[i].wt;
      } else {
        profit += (double) w / list[i].wt * list[i].val;
        break;
      }
    }
    return profit;
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while (tc-- > 0) {
      String[] nw = br.readLine().trim().split(" ");
      String[] valWt = br.readLine().trim().split(" ");
      DecimalFormat df = new DecimalFormat("#0.00");
      n = Integer.parseInt(nw[0]);
      w = Integer.parseInt(nw[1]);
      value = new int[n];
      weight = new int[n];
      int k = 0;
      for (int i = 0; i < n; i++) {
        value[i] = Integer.parseInt(valWt[k++]);
        weight[i] = Integer.parseInt(valWt[k++]);
      }
        
      list = new Item[n];
      for (int i = 0; i < n; i++) {
        list[i] = new Item(value[i], weight[i]);
      }

      heapsort();
      for (int i = list.length - 1; i >= 0; i--) {
        Item temp = list[n - 1];
        list[n - 1] = list[0];
        list[0] = temp;
        n--;
        heapify(0);
      }
      System.out.println(df.format(knapsack()));
    }
  }
}
