import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author Medhashree Adhikari
 */

public class Quicksort implements Sorter {

  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new Quicksort();

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  Quicksort() {
  } // Quicksort()

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /**
   * call to quicksort
   */
  @Override
  public <T> void sort(T[] values, Comparator<? super T> order) {
    quicksort(values, order, 0, values.length - 1);
  } // sort(T[], Comparator<? super T>

  /**
   * Partition an array.
   */
  public <T> void partition(T[] values, Comparator<? super T> order) {
    partition(values, order, 0, values.length + 1);
  } // partition(T[], Comparator<? super T>)

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * Sort the subarray of T given by [lb..ub) in place using
   * the Quicksort algorithm.
   * @param <T>
   * @param values
   * @param order
   * @param lb
   * @param ub
   */
  private static <T> void quicksort(T[] values, Comparator<? super T> order, int lb, int ub) {
    /*
     * base case:
     * when lb == ub
     * when arr.length == 0
     */
    if ((lb == ub) || (values.length == 0)) {
      return;
    }

    /**
     * recursive:
     * find pivot
     * sort less than/greater than pivot
     * 1. sort left side (less than pivot until lb)
     * --> unless smallest value
     * 2. sort right side (greater than pivot until ub)
     * --> unless greatest value
     */
    int left = lb;
    int right = ub;
    int pivot = partition(values, order, left, right);
    T[] newValues = swapper.swap(values, left, pivot);
    if (values[left] != values[pivot]) {
      left++;
    }
    

    while (left < right) {
      // if element in index i is less than element in pivot,
      // then comparator will return 1
      // if 1 is returned,
      if (order.compare(newValues[left], newValues[lb]) > 0) {
        // swap end value and cur value
        swapper.swap(newValues, left, right);
        right--; // shift right towards left
      } else {
        left++;
      } // condition check
    } // while loop

    // put pivot in correct place
    if (order.compare(newValues[lb], newValues[left]) > 0) {
      pivot = left;
      swapper.swap(newValues, pivot, lb);
    } else {
      pivot = left - 1;
      swapper.swap(newValues, pivot, lb);
    }

    // left section of the array
    if (pivot != lb) {
      quicksort(newValues, order, lb, pivot - 1);
    }

    // right section of the array
    if (pivot != ub) {
      quicksort(newValues, order, pivot + 1, ub);
    }
  } // quicksort(T[], Comparator<? super T>, lb, ub)

  /**
   * Select a pivot and partition the subarray from [lb .. ub) into
   * the following form.
   *
   * <pre>
   * ---+-----------------+-+----------------+---
   *    | values <= pivot |p| values > pivot |
   * ---+-----------------+-+----------------+---
   *    |                 |                  |
   *    lb                pivotLoc           ub
   * </pre>
   *
   * @return pivotLoc.
   */

  static <T> int partition(T[] arr, Comparator<? super T> order, int lb, int ub) {
    int pivotLoc = (lb + ub) / 2;
    return pivotLoc;
  } // partition(T[], Comparator<? super T>, lb, ub)
} // class Quicksort
