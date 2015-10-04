package kata.findsubarray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ArraysTest {

  private Arrays arrays = new Arrays();

  private int[] first;
  private int[] second;
  private int startingIndex;
  private boolean isSubArray;
  private boolean lastElementMatches;

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return java.util.Arrays.asList(new Object[][]{
        {new int[]{4, 5}, new int[]{}, 0, false, false},
        {new int[]{4, 5}, new int[]{2, 4, 5, 6}, 1, true, true},
        {new int[]{4, 5}, new int[]{2, 3, 4, 5}, 2, true, true},
        {new int[]{4, 5}, new int[]{2, 4, 4, 5}, 2, true, true},
        {new int[]{4, 5}, new int[]{2, 3, 4, 4, 4, 5, 6, 7}, 4, true, true},
        {new int[]{4, 5}, new int[]{2, 3, 4, 4, 4, 6, 7}, 4, false, false},
        {new int[]{4, 5, 5}, new int[]{2, 3, 4, 5, 5}, 2, true, true},
        {new int[]{4, 5, 5}, new int[]{2, 3, 4, 5}, 2, false, false},
        {new int[]{4, 5, 5}, new int[]{4, 5}, 0, false, false}
    });
  }

  public ArraysTest(int[] first, int[] second, int index, boolean isSubArray, boolean lastMatches) {
    this.first = first;
    this.second = second;
    this.startingIndex = index;
    this.isSubArray = isSubArray;
    this.lastElementMatches = lastMatches;
  }

  @Test(expected = IllegalArgumentException.class)
  public void testNegativeIndexElementMatches() throws Exception {
    arrays.lastElementMatches(first, second, -1);
  }

  @Test
  public void testIsSubArray() throws Exception {
    assertEquals(isSubArray, arrays.isSubArray(first, second, startingIndex));
  }

  @Test
  public void testLastElementMatches() throws Exception {
    assertEquals(lastElementMatches, arrays.lastElementMatches(first, second, startingIndex));
  }
}