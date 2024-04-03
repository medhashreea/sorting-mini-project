import java.util.Arrays;
import java.util.Comparator;

public class sortExpts {
  public static void main(String[] args) {
    Integer[] vals0 = new Integer[] { 3, 9, 2, 8, 6, 4, 1, 7, 5 };
    Comparator<Integer> compareInts = (x, y) -> x.compareTo(y);

    partitionExperiment(vals0, compareInts);
  } // main(String[])

  /**
   * A partition experiment.
   */
  public static <T> void partitionExperiment(T[] vals, Comparator<? super T> order) {
    // QUICKSORT
    // System.err.println("QS Original:    " + Arrays.toString(vals));
    // int pivotLoc = Quicksort.partition(vals, order, 0, vals.length);
    // System.err.println("QS Pivot is " + vals[pivotLoc] + " at position " + pivotLoc);
    // Quicksort.SORTER.sort(vals, order);
    // System.err.println("QS Partitioned: " + Arrays.toString(vals));
    
    // System.err.println("insert Original:    " + Arrays.toString(vals));
    // InsertionSort.SORTER.sort(vals, order);
    // System.err.println("insert Partitioned: " + Arrays.toString(vals));


    System.err.println("MS Original:    " + Arrays.toString(vals));
    MergeSort.SORTER.sort(vals, order);
    System.err.println("MS Partitioned: " + Arrays.toString(vals));
  } // partitionExperiment
}
