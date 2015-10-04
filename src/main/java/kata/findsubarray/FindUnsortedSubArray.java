package kata.findsubarray;

/**
 * Finds a unsorted sub-array inside an unsorted array
 */
public class FindUnsortedSubArray implements FindSubArray {

  private Arrays arrays = new Arrays();

  /**
   * {@inheritDoc}
   *
   * @throws IllegalArgumentException if empty sub-array was given
   */
  @Override
  public int indexOfSubArray(int[] subArray, int[] array) {
    if (subArray.length == 0) {
      throw new IllegalArgumentException("Empty sub-array was given");
    }

    int startingIndex = 0;
    while ((subArray.length + startingIndex) <= array.length) {
      if (arrays.isSubArray(subArray, array, startingIndex)) {
        return startingIndex;
      } else {
        int firstPositionFound = indexOf(subArray[0], array, startingIndex + 1);
        if (firstPositionFound == -1) {
          return -1;
        } else {
          startingIndex = firstPositionFound;
        }
      }
    }
    return -1;
  }

  /**
   * Finds the index of a value inside the given array
   *
   * @param value         the value to search for
   * @param array         the array expected to contain the given value
   * @param startingIndex defines the position we should start searching from
   * @return the position (zero-based) of the value inside the given array or -1 if it was not found
   */
  private int indexOf(int value, int[] array, int startingIndex) {
    for (int i = startingIndex; i < array.length; i++) {
      if (value == array[i]) {
        return i;
      }
    }
    return -1;
  }
}
