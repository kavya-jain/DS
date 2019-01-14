package array;

public class AlternatePositiveNegative2 {
  
  public static void main(String[] args) {
    
    int[] array = { -5, -2, 5, 2, 4, 7, 1, 8, 0, -8 };
    
    int i=0, flag=-1;
    while(i<array.length) {
      if(flag!=-1) {
        
        if((array[flag]>=0 && array[i]<0) || (array[i]>=0 && array[flag]<0)) {
          rightRotate(array, flag, i);
          if(i-flag>=2)
            flag+=2;
          else
            flag=-1;
        }
      }
      
      if(flag==-1) {
        if((i%2==0 && array[i]>0) ||(i%2==1 && array[i]<0))
          flag=i;
      }
      i++;
    }
    for(int ele : array)
      System.out.println(ele);
  }

  private static void rightRotate(int[] array, int flag, int index) {
    int temp = array[index];
    for(int i=index; i>flag; i--)
      array[i]=array[i-1];
    array[flag] = temp;
  }

}
