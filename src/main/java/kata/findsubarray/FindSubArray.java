package kata.findsubarray;

/**
 * Finds a sub-array inside an array
 */
public interface FindSubArray {

  /**
   * Returns the starting index of the sub-array found in the given array
   *
   * @param subArray to search for
   * @param array    array to check if the given sub-array exists
   * @return the position of the first element of the sub-array inside the given array
   */
  int indexOfSubArray(int[] subArray, int[] array);
}
