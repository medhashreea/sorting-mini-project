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

  // +---------+-----------------------------------------------------
  // | Methods |
  // +---------+

  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    /**
     * base case
     * if 
     *    empty --> values.length == 0
     *    or null --> values == null
     * do nothing!
     */
    if ((values.length <= 1) || (values == null)) {
      return;
    }
    // recursive case
    mergeSort(values, order, 0, values.length);
  } // sort(T[], Comparator<? super T>

  static <T> void mergeSort(T[] values, Comparator<? super T> order, int lb, int ub) {
    if(lb < ub) {
      int mid = (lb + ub) / 2;
      // sort each side
      mergeSort(values, order, lb, mid); // left is mid inclusive
      mergeSort(values, order, mid + 1, ub); // right is mid exclusive
      merge(values, order, lb, ub, mid);
    } // if left side is less than right side
  } // mergeSort(T[] values, Comparator<? super T> order, int lb, int ub)

  private static <T> void merge(T[] values, Comparator<? super T> order, int lb, int ub, int mid) {
    // temp left and right arrays
    T[] temp = values.clone();
    int left = lb;
    int right = mid;
    int i = 0;

    while((left < mid) && (right < ub)) {
      // if left is less than right
      if (order.compare(temp[left], temp[right]) <= 0) {
        values[i++] = temp[left++];
      } else {
        values[i++] = temp[right++];
      }
    } // loop

    // clear up left side
    while(left < mid) {
      values[i++] = temp[left++];
    }

    // clear up right side
    while(right < ub) {
      values[i++] = temp[right++];
    }
  }
} // class MergeSort