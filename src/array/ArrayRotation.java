package array;

public class ArrayRotation {

  public static void main(String[] args) {

    int[] array = { 1, 2, 3, 4, 5, 6, 7 };

    int rotationFactor = 2;

    int[] rotatedArray = rotateArray(array, rotationFactor);

    for(int i: rotatedArray)
      System.out.println(i);
    
    int element = 2;
    int index;
    int pivot = rotatedArray[array.length-rotationFactor];
    if(pivot == element)
      index = array.length-rotationFactor;
    else if(element>rotatedArray[0])
      index = binarySearch(rotatedArray, 0, array.length-rotationFactor-1, element);
    else
      index = binarySearch(rotatedArray, array.length-rotationFactor, array.length, element);
    System.out.println(index);
  }

  private static int binarySearch(int[] rotatedArray, int start, int end, int element) {
    
    int middle = (start+end)/2;
    if(element == rotatedArray[middle])
      return middle;
    if(element > rotatedArray[middle])
      return binarySearch(rotatedArray, middle+1, end, element);
    return binarySearch(rotatedArray, start, middle-1, element);
  }

  private static int[] rotateArray(int[] array, int rotationFactor) {

    int[] tempArray = new int[rotationFactor];
    for (int i = 0; i < rotationFactor; i++) {
      tempArray[i] = array[i];
    }
    int tempRotation = rotationFactor;
    for (int i = 0; i < array.length; i++) {
      if (i + tempRotation >= array.length)
        tempRotation--;
      array[i] = array[i + tempRotation];
    }
    for (int i = array.length - rotationFactor, j = 0; i < array.length; i++, j++) {
      array[i] = tempArray[j];
    }
    return array;
  }
}