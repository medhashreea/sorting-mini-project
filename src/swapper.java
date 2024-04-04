/**
 * swapper class to avoid repeated code.
 * swaps the elements in index 'i' and 
 * index 'j' in the 'arr' array
 * 
 * @author Medhashree Adhikari
 */
public class swapper {
  // +----------------+----------------------------------------------
  // | Public Methods |
  // +----------------+
  /**
   * swap takes two index values and an array
   * and swaps the two elements
   * 
   * @param <T>
   * @param arr
   * @param i
   * @param j
   * @return arr
   */
  public static <T> T[] swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;

    return arr;
  } // swap(T[] arr, int i, int j)
} // swapper class
