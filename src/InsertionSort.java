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

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /**
   * sorts the values using swapper class
   * 
   * @param values
   * @param order
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    // array length
    int len = values.length;

    // i starts at index 1 because element in index 0 
    for(int i = 1; i < len; ++i) {
      // loop until j is 0 AND the prev value is <= the value we're looking at
      for(int j = i; (j > 0) && (order.compare(values[j - 1], values[j]) > 0); j--) {
        swapper.swap(values, j, j-1); // swap if true
      } // inner loop
    } // outer loop
  } // sort(T[], Comparator<? super T>
} // class InsertionSort