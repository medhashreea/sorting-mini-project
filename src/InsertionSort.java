import java.util.Comparator;

/**
 * Sort using insertion sort.
 *
 * @author Medhashree Adhikari
 */

public class InsertionSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new InsertionSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  InsertionSort() {
  } // InsertionSort()

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * sort
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // array length
    int len = values.length;

    // else loop over array
    // sort as long as i < values.length
    // i starts at index 1 because element in index 0 
    // comapred to element in index 0 is equal 
    for(int i = 1; i < len; ++i) {
      /**
       * loop as long as j is greater than 0
       * AND the prev value is greater than the value we're looking at
       */
      for(int j = i; (j > 0) && (order.compare(values[j - 1], values[j]) > 0); j--) {
        swapper.swap(values, j, j-1);
      }
    } // loop
    // for(int i = 1; i < len; i++) {
    //   T curVal = values[i];
    //   int j = i - 1;

    //   while ((j >= 0) && (order.compare(values[j], curVal) > 0)) {
    //     values[j + 1] = values[j];
    //     j--;
    //   }
    //   values[j + 1] = curVal;
    // } // loop

  } // sort(T[], Comparator<? super T>
} // class InsertionSort