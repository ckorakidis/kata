package kata.findsubarray;

/**
 * Arrays utility
 */
public class Arrays {

  /**
   * Checks if the first given array is a sub-array of the second given array starting from the
   * given index
   *
   * @param first      the array to check if is sub-array of the second given array
   * @param second     the array where the given first array is expected to exist
   * @param startIndex the starting index of the sub-array inside the given array
   * @return true if the given first array is a sub-array of the given second array.
   */
  public boolean isSubArray(int[] first, int[] second, int startIndex) {
    if (!lastElementMatches(first, second, startIndex)) {
      return false;
    }

    for (int i = 0; i < first.length - 1; i++) {
      if (first[i] != second[i + startIndex]) {
        return false;
      }
    }
    return true;
  }

  /**
   * Checks if the last element of the first given array is equal to the element of the respective
   * position in the second given array, starting from the startIndex, e.g. for {4, 5}, {2,3,4,5}, 2
   * it returns true, for {4, 5}, {2,3,4,6}, 2 it returns false
   *
   * @param first      the array to check if is sub-array of the second given array
   * @param second     the array where the given first array is expected to exist
   * @param startIndex the starting index of the sub-array inside the given array
   * @return true if the last element of the first given array is equal to the element of the
   * respective position in the second given array
   */
  public boolean lastElementMatches(int[] first, int[] second, int startIndex) {
    if (startIndex < 0) {
      throw new IllegalArgumentException("starting index must be >= 0");
    }
    return (first.length + startIndex <= second.length) && (
        first[first.length - 1] == second[startIndex + first.length - 1]);
  }
}
