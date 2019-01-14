package array;

public class MagicSquare {
  
  static int[][] square;
  static int n;
  
  public static void build() {
    
    square = new int[n][n];
    
    int i=0, j=0, k=1;
    for(i=0; i<n; i++) {
      for(j=0; j<n; j++)
        square[i][j]=-1;
    }
    square[n/2][n-1] = 1;
    i=n/2; j=n-1; k=1;    
    while(k<=n*n-1) {
      i=i-1;
      j=j+1;
      
      if(i==-1 && j==n) {
        i=0;
        j=n-2;
      }
      
      else if(i==-1)
        i=n-1;
      else if(j==n)
        j=0;
      
      if(square[i][j]!=-1) {
        j=j-2;
        i=i+1;
      }
        
      square[i][j] = ++k;
          
    }
  }
  
  public static void main(String[] args) {
    n=7;
    build();
    for(int i=0; i<n; i++) {
      for(int j=0; j<n; j++) {
        System.out.print(square[i][j]+" ");
      }
      System.out.println();
    }
    
        
  }

}
