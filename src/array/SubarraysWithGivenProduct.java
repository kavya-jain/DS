package array;

public class SubarraysWithGivenProduct {

  public static void main(String[] args) {
    int[] arr = {1,2,3,4,1};
    int i=0, j=0, p =1, k=24, ones=0, res=0;
    
    while(j<arr.length) {
      p*=arr[j];
      if(p>k) {
        while(i<j && p>k) {
          p/=arr[i];
          i++;
        }
      }
      if(p==k) {
        ones=0;
        while(j+1<arr.length && arr[j+1]==1) {
          ones +=1;
          j++;
        }
        res +=ones+1;
        while(i<j && arr[i]==1) {
          res += ones+1;
          i++;
        }
       p/=arr[i];
       i++;
      }
      j++;
    }
    
    System.out.println(res);
  }
  
}
