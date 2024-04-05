import java.util.Arrays;
import java.util.Comparator;

public class sortExpts {
  public static void main(String[] args) {
    // Integer[] vals0 = new Integer[] { 3, 9, 2, 8, 6, 4, 1, 7, 5 };
    // Comparator<Integer> compareInts = (x, y) -> x.compareTo(y);
    // partitionExperiment(vals0, compareInts);
    
    // String[] original = { "horses", "just", "all", "trot", "all", "green" };
    // String[] expected = { "all", "all", "green", "horses", "just", "trot" };

    String[] original = { "h", "j", "a", "t", "c", "green" };

    // String[] original = { "horses", "just", "8", "1", "all", "green" };
    //String[] expected = { "1", "8", "all", "green", "horses", "just" };

    // String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    // String[] expected = original.clone();
    // String[] original = { "alpha", "bravo", "6", "1", "5" };
    // String[] expected = original.clone();

    Comparator<String> compareStr = (x, y) -> x.compareTo(y);

    partitionExperiment(original, compareStr);
  } // main(String[])

  /**
   * A partition experiment.
   */
  public static <T> void partitionExperiment(T[] vals, Comparator<? super T> order) {
    // INSERTIONSORT
    // System.err.println("insert Original:    " + Arrays.toString(vals));
    // InsertionSort.SORTER.sort(vals, order);
    // System.err.println("insert Partitioned: " + Arrays.toString(vals));

    // MERGESORT
    // System.err.println("MS Original:    " + Arrays.toString(vals));
    // MergeSort.SORTER.sort(vals, order);
    // System.err.println("MS Partitioned: " + Arrays.toString(vals));

    // QUICKSORT
    // System.err.println("QS Original:    " + Arrays.toString(vals));
    // int pivotLoc = Quicksort.partition(vals, order, 0, vals.length);
    // System.err.println("QS Pivot is " + vals[pivotLoc] + " at position " + pivotLoc);
    // Quicksort.SORTER.sort(vals, order);
    // System.err.println("QS Partitioned: " + Arrays.toString(vals));

    System.err.println("Me Original:    " + Arrays.toString(vals));
    AdhikariMedhashreeSort.SORTER.sort(vals, order);
    System.err.println("Me Partitioned: " + Arrays.toString(vals));
  } // partitionExperiment
}
