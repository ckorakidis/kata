package kata.findsubarray;

/**
 * Finds a sorted sub-array inside a sorted array
 */
public class FindSortedSubArray implements FindSubArray {

  private Arrays arrays = new Arrays();

  /**
   * {@inheritDoc}
   *
   * @throws java.lang.IllegalArgumentException if empty sub-array was given
   */
  @Override
  public int indexOfSubArray(int[] subArray, int[] array) {
    if (subArray.length == 0) {
      throw new IllegalArgumentException("Empty sub-array was given");
    }
    if (array.length < subArray.length) {
      return -1;
    }

    int firstPositionFound = indexOf(subArray[0], array);

    int expectedStartingIndex = startingIndex(firstPositionFound, subArray, array);
    if (expectedStartingIndex < 0) {
      return -1;
    }

    return arrays.isSubArray(subArray, array, expectedStartingIndex) ? expectedStartingIndex : -1;
  }

  /**
   * Finds the index of a value inside the given sorted array
   *
   * @param value the value to search for
   * @param array the array expected to contain the given value
   * @return the position (zero-based) of the value inside the given array or -1 if it was not found
   */
  private int indexOf(int value, int[] array) {
    int start = 0;
    int end = array.length - 1;
    while (start <= end) {
      int middle = start + (end - start) / 2;

      if (value < array[middle]) {
        end = middle - 1;
      } else if (value > array[middle]) {
        start = middle + 1;
      } else {
        return middle;
      }
    }
    return -1;
  }

  /**
   * Finds the index on the given array where the sequence of the first element occurrences on the
   * given subArray matches the sequence on the array, e.g. {4, 5}, {2, 3, 4, 4, 5}, 2 would return
   * 3
   *
   * @param firstIndexFound the initial index where the first element of the subArray is equal to
   *                        the element in the position firstIndexFound of the array
   * @param subArray        the subArray to check it's first element
   * @param array           the array to check the occurrences of the subArrays' first element
   * @return the starting index or -1 in case there was not found the sequence of the elements equal
   * to the first element of the subArray
   */
  private int startingIndex(int firstIndexFound, int[] subArray, int[] array) {
    if (firstIndexFound == -1) {
      return -1;
    }
    int offset = offset(firstIndexFound, subArray, array);

    if (offset < 0) {
      return -1;
    }

    return firstIndexFound + offset;
  }

  /**
   * Finds the positions the starting index which defines the beginning of the sequence of the
   * elements equal to the first element of the subArray found in the array, should be shifted
   *
   * @param firstIndexFound the initial index where the first element of the subArray is equal to
   *                        the element in the position firstIndexFound of the array
   * @param subArray        the subArray to check it's first element
   * @param array           the array to check the occurrences of the subArrays' first element
   * @return the offset the starting index should be shifted or -1 in case there was not found in
   * the array the sequence of the elements equal to the first element of the subArray
   */
  private int offset(int firstIndexFound, int[] subArray, int[] array) {
    int timesFirstIsRepeatedInSubArray = findTimesValueIsRepeated(subArray, 0);
    int timesRepeatedInArray = findTimesValueIsRepeated(array, firstIndexFound);
    return timesRepeatedInArray - timesFirstIsRepeatedInSubArray;
  }

  /**
   * finds subsequent occurrences of the value after the given index position, e.g. for {2, 3, 4, 4,
   * 4, 4, 4, 4, 5}, 2 it should return 6
   *
   * @param array the array to search for
   * @param index of the starting point to check
   * @return the times the value in the position index is repeated in the positions following the
   * index
   * @throws java.lang.IllegalArgumentException if the array is empty
   */
  private int findTimesValueIsRepeated(int[] array, int index) {
    if (array.length == 0) {
      throw new IllegalArgumentException("Empty array was given");
    }
    int value = array[index];
    int times = 1;
    for (int i = index + 1; i < array.length - 1; i++) {
      if (array[i] == value) {
        times++;
      } else {
        return times;
      }
    }
    return times;
  }
}
