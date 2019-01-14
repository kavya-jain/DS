package array;

public class ReverseArrayString {

  public static void main(String[] args) {

    int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

    for (int i = 0, j = array.length - 1; i<array.length/2; i++, j--) {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }
    
    for(int i : array)
      System.out.println(i);
    
    String string = "kavya";
    
    char[] strArray = string.toCharArray();
    for (int i = 0, j = strArray.length - 1; i<strArray.length/2; i++, j--) {
      char temp = strArray[i];
      strArray[i] = strArray[j];
      strArray[j] = temp;
    }
    
    string = new String(strArray);
    System.out.println(string);
    
  }

}
