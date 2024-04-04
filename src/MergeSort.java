import java.util.Arrays;
import java.util.Comparator;

/**
 * Sort using merge sort.
 *
 * @author Medhashree Adhikari
 */

public class MergeSort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new MergeSort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  MergeSort() {
  } // MergeSort()

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /**
   * sort begins checking the base and recusive case
   * 
   * @param values
   * @param order
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    /**
     * base case
     * if 
     *    empty --> values.length == 0
     *    or null --> values == null
     * there is nothing to sort!
     */
    if ((values.length <= 1) || (values == null)) {
      return;
    }

    // recursive case
    mergeSort(values, order, 0, values.length - 1);
  } // sort(T[], Comparator<? super T>

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * mergeSort "breaks" down the array
   * 
   * @param <T>
   * @param values
   * @param order
   * @param lb
   * @param ub
   */
  private static <T> void mergeSort(T[] values, Comparator<? super T> order, int lb, int ub) {
    if(lb < ub) {
      int mid = (lb + ub) / 2;
      // sort each side
      mergeSort(values, order, lb, mid); // left is mid inclusive
      mergeSort(values, order, mid + 1, ub); // right is mid exclusive
      merge(values, order, lb, ub, mid);
    } 
  } // mergeSort(T[] values, Comparator<? super T> order, int lb, int ub)

  /**
   * merge sorts the broken down elements
   * 
   * @param <T>
   * @param values
   * @param order
   * @param lb
   * @param ub
   * @param mid
   */
  private static <T> void merge(T[] values, Comparator<? super T> order, int lb, int ub, int mid) {
    // temp left and right arrays
    T[] temp = Arrays.copyOf(values, values.length);
    int left = lb;
    int right = mid + 1;
    int i = lb;

    while((left <= mid) && (right <= ub)) {
      // if left is less than right
      if (order.compare(temp[left], temp[right]) <= 0) {
        // replace it in the main array and advance left and i
        values[i++] = temp[left++];
      } else {
        // replace it in the main array and advance right and i
        values[i++] = temp[right++];
      }
    } // loop

    // clear up left side
    while(left <= mid) {
      values[i++] = temp[left++];
    } // loop

    // clear up right side
    while(right <= ub) {
      values[i++] = temp[right++];
    } // loop
  } // merge(T[] values, Comparator<? super T> order, int lb, int ub, int mid)
} // class MergeSort