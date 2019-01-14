package array;

public class SubsetsOfArrayRecurssion {
  
  public static void print_set(int[] subset) {
    System.out.print("{");
    for(int a : subset) {
      if(a != -1)
        System.out.print(a+",");
    }
    System.out.println("}");

  }

  public static void sets(int[] arr) {
    int[] subset = new int[arr.length];
    rec(arr, subset, 0);
  }

  public static void rec(int[] arr, int[] subset, int i) {
    if (i == arr.length)
      print_set(subset);
    else {
      subset[i] = -1;
      rec(arr, subset, i+1);
      subset[i] = arr[i];
      rec(arr, subset, i+1);
    }
  }
  
  public static void main(String[] args) {
    int[] arr = {1,2};
    sets(arr);
  }
}
