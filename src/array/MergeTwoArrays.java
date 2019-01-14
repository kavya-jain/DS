package array;

public class MergeTwoArrays {
  
  public static void main(String[] args) {
    
    int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20}; 
    int N[] = {5, 7, 9, 25}; 
    
    int j = mPlusN.length-1;
    for(int i=mPlusN.length-1; i>=0; i--) {
      if(mPlusN[i]!=-1) {
        mPlusN[j] = mPlusN[i];
        j--;
      }
    }
    j=N.length;
    int k=0;
    for(int i=0; i<mPlusN.length; i++) {
      if(j==mPlusN.length) {
        mPlusN[i] = N[k++];
        continue;
      }
      
      if(k==N.length) {
        mPlusN[i] = mPlusN[j++];
        continue;
      }
      
      if(N[k] < mPlusN[j]) {
        mPlusN[i] = N[k];
        k++;
      }
        
      else if(N[k] > mPlusN[j]) {
        mPlusN[i] = mPlusN[j];
        j++;
      }
      else {
        mPlusN[i++] = N[k];
        mPlusN[i] = mPlusN[j];
        k++;
        i++;
      }
    }
    
    for(int a: mPlusN)
      System.out.println(a + " ");
  }

}
