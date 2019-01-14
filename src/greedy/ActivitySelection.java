package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ActivitySelection {

  public static int[] start, finish;
  static int n;

  public static void mergesort(int s, int e) {
    if (s < e) {
      int mid = (s+e)/2;
      mergesort(s, mid);
      mergesort(mid + 1, e);
      merge(s,mid,e);
    }
  }

  public static void merge(int s, int mid, int e) {
    int p=s, q=mid+1, k=0, h=s;
    int[] A = new int[e-s+1];
    int[] B = new int[e-s+1];
    for(int i=s; i<=e; i++)  {
      if(p>mid) {
        A[k] = finish[q];
        B[k++] = start[q++];
      }
      else if(q>e) {
        A[k] = finish[p];
        B[k++] = start[p++];
      }
      else if(finish[p]<finish[q]) {
        A[k] = finish[p];
        B[k++] = start[p++];
      }
      else if(finish[p]>=finish[q]) {
        A[k] = finish[q];
        B[k++] = start[q++];
      }
    }
    for(int i=0; i<k; i++) {
      finish[s] = A[i];
      start[s++] = B[i];
    }
  }

  public static void meetings() {

    mergesort(0, start.length - 1);
    int i = 0;
    System.out.print(i + " ");

    for (int j = 1; j < start.length; j++) {
      if (start[j] > finish[i]) {
        System.out.print(j+" ");
        i = j;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int tc = Integer.parseInt(br.readLine());
    while(tc-->0){
        int n = Integer.parseInt(br.readLine());
        String[] a1 = br.readLine().trim().split(" ");
        String[] a2 = br.readLine().trim().split(" ");
        start = new int[n];
        finish = new int[n];
        for(int i=0; i<n; i++){
            start[i] = Integer.parseInt(a1[i]);
            finish[i] = Integer.parseInt(a2[i]);
        }
        meetings();
        System.out.println();
    }

  }
}
