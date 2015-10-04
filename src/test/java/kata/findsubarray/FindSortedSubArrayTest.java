package kata.findsubarray;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FindSortedSubArrayTest {

  private FindSubArray finder = new FindSortedSubArray();

  private int[] subArray;
  private int[] array;
  private int expectedIndex;

  @Parameterized.Parameters
  public static Collection<Object[]> data() {
    return Arrays.asList(new Object[][]{
        {new int[]{4, 5}, new int[]{}, -1},
        {new int[]{4, 5}, new int[]{2, 4, 5, 6}, 1},
        {new int[]{4, 5}, new int[]{2, 3, 4, 5}, 2},
        {new int[]{4, 5}, new int[]{2, 4, 4, 5}, 2},
        {new int[]{4, 5}, new int[]{2, 3, 4, 4, 4, 5, 6, 7}, 4},
        {new int[]{4, 5}, new int[]{2, 3, 4, 4, 4, 6, 7}, -1},
        {new int[]{4, 5, 5}, new int[]{2, 3, 4, 5, 5}, 2},
        {new int[]{4, 5, 5}, new int[]{2, 3, 4, 5}, -1},
        {new int[]{4, 5, 5}, new int[]{4, 5}, -1}
    });
  }

  public FindSortedSubArrayTest(int[] subArray, int[] array, int index) {
    this.subArray = subArray;
    this.array = array;
    this.expectedIndex = index;
  }

  @Test
  public void testIndexOfSubArray() throws Exception {
    assertEquals(expectedIndex, finder.indexOfSubArray(subArray, array));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testIndexOfEmptySubArray() throws Exception {
    finder.indexOfSubArray(new int[]{}, array);
  }
}