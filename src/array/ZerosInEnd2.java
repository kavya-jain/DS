package array;

  import java.util.Scanner;

  public class ZerosInEnd2 {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        int testcases = scan.nextInt();
        while(testcases-->0){
            int n = scan.nextInt();
            int[] array = new int[n];
            for(int i=0; i<n; i++){
                array[i] = scan.nextInt();
            }
            int zeros = 0;
            for(int i=0; i<n; i++) {
                if(array[i]!=0){
                    int temp = array[i];
                    array[i] = array[zeros];
                    array[zeros] = temp;
                    zeros++;
                }
            }
            
            for(int a : array){
                System.out.print(a +" ");
            }
            System.out.println();
        }
        scan.close();
    }

  }


