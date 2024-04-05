import java.util.Comparator;

/**
 * Sort using Quicksort.
 *
 * @author ChatGPT 3.5
 * @author Medhashree Adhikari
 */

public class AdhikariMedhashreeSort implements Sorter {
  // +--------+------------------------------------------------------
  // | Fields |
  // +--------+

  /**
   * The one sorter you can access.
   */
  public static Sorter SORTER = new AdhikariMedhashreeSort();

  private static final int MIN_MERGE = 32;

  // +--------------+------------------------------------------------
  // | Constructors |
  // +--------------+

  /**
   * Create a sorter.
   */
  AdhikariMedhashreeSort() {
  } // AdhikariMedhashreeSort()

  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+

  /**
   * sort
   */
  @Override
  public <T> void sort(T[] array, Comparator<? super T> comparator) {
    int length = array.length;

    if (length < 2) {
      return;
    }

    int minRun = computeMinRunLength(length);

    for (int i = 0; i < length; i += minRun) {
      int end = Math.min(i + minRun, length);
      insertionSort(array, i, end, comparator);
    }

    for (int size = minRun; size < length; size <<= 1) {
      for (int start = 0; start < length; start += size << 1) {
        int middle = Math.min(start + size, length);
        int end = Math.min(start + (size << 1), length);
        merge(array, start, middle, end, comparator);
      }
    }
  } // sort(T[] array, Comparator<? super T> comparator)

  // +-----------------+---------------------------------------------
  // | Private Methods |
  // +-----------------+

  /**
   * implementation of insertion sort
   * 
   * @param <T>
   * @param array
   * @param start
   * @param end
   * @param comparator
   */
  private <T> void insertionSort(T[] array, int start, int end, Comparator<? super T> comparator) {
    for (int i = start + 1; i < end; i++) {
      T key = array[i];
      int j = i - 1;

      while (j >= start && comparator.compare(key, array[j]) < 0) {
        array[j + 1] = array[j];
        j--;
      } // inner loop

      array[j + 1] = key;
    } // loop
  } // insertionSort(T[] array, int start, int end, Comparator<? super T>
    // comparator)

  /**
   * implementation of merge sort
   * 
   * @param <T>
   * @param array
   * @param start
   * @param middle
   * @param end
   * @param comparator
   */
  private <T> void merge(T[] array, int start, int middle, int end, Comparator<? super T> comparator) {
    int len1 = middle - start;
    int len2 = end - middle;

    Object[] left = new Object[len1];
    Object[] right = new Object[len2];
    System.arraycopy(array, start, left, 0, len1);
    System.arraycopy(array, middle, right, 0, len2);

    int i = 0, j = 0, k = start;

    // loop to sort the broken down values
    while (i < len1 && j < len2) {
      if (comparator.compare((T) left[i], (T) right[j]) <= 0) {
        array[k++] = (T) left[i++];
      } else {
        array[k++] = (T) right[j++];
      }
    } // while loop

    // cleaning up left
    while (i < len1) {
      array[k++] = (T) left[i++];
    } // while loop

    // cleaning up right
    while (j < len2) {
      array[k++] = (T) right[j++];
    } // while loop
  } // merge(T[] array, int start, int middle, int end, Comparator<? super T>
    // comparator)

  /**
   * computeMinRunLength
   * 
   * determines the minimum size of a run n the array before merging
   * 
   * @param n
   * @return
   */
  private static int computeMinRunLength(int n) {
    int r = 0;

    while (n >= MIN_MERGE) {
      r |= (n & 1);
      n >>= 1;
    } // while loop

    return n + r;
  } // computeMinRunLength(int n)
} // class AdhikariMedhashreeSort