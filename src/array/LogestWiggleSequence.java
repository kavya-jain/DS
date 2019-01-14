package array;

public class LogestWiggleSequence {
  
  public static void main(String[] args) {
    int[] arr = {1,17,5,10,13,15,10,5,16,8};
    int up=1, down=1;
    
    for(int i=0; i<arr.length-1; i++) {
      if(arr[i]>arr[i+1])
        up = down+1;
      if(arr[i]<arr[i+1])
        down = up+1;
    }
    System.out.println(Math.max(up, down));
  }

}
