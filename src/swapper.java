public class swapper {
  /**
   * swap takes two index values and an array
   * and swaps the two elements
   * 
   * @param <T>
   * @param arr
   * @param i
   * @param j
   * @return
   */
  public static <T> T[] swap(T[] arr, int i, int j) {
    T temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
    return arr;
  }
} // swapper class
