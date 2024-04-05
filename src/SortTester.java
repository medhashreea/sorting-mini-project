import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

/**
 * Tests of Sorter objects.
 *
 * @author Medhashree Adhikari
 */
public class SortTester {

  // +---------+-----------------------------------------------------
  // | Globals |
  // +---------+

  Sorter sorter;

  // +-------+-------------------------------------------------------
  // | Tests |
  // +-------+

  @Test
  public void fakeTest() {
    assertTrue(true);
  } // fakeTest()

  @Test
  public void orderedStringTest() {
    String[] original = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    String[] expected = original.clone();
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  @Test
  public void reverseOrderedStringTest() {
    String[] original = { "foxtrot", "delta", "charlie", "bravo", "alpha" };
    String[] expected = { "alpha", "bravo", "charlie", "delta", "foxtrot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // orderedStringTest

  // +----------+----------------------------------------------------
  // | My Tests |
  // +----------+
  @Test
  public void emptyArrTest() {
    String[] original = {};
    String[] expected = {};
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // emptyArrTest

  @Test
  public void oneElementTestInt() {
    Integer[] original = { 18 };
    Integer[] expected = { 18 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // oneElementTestInt

  @Test
  public void oneElementTestStr() {
    String[] original = { "hello" };
    String[] expected = { "hello" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // oneElementTestStr

  @Test
  public void varietyElementTestInt() {
    Integer[] original = { 758, 238, 512, 9, 238, 1692, 238, 3, 512, 7 };
    Integer[] expected = { 3, 7, 9, 238, 238, 238, 512, 512, 758, 1692 };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // varietyElementTestInt

  @Test
  public void varietyElementTestStr() {
    String[] original = { "horses", "all", "trot", "all", "all", "green" };
    String[] expected = { "all", "all", "all", "green", "horses", "trot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // varietyElementTestStr

  @Test
  public void numStrings() {
    String[] original = { "horses", "just", "8", "trot", "all", "1" };
    String[] expected = { "1", "8", "all", "horses", "just", "trot" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // numStrings

  @Test
  public void charsWords() {
    String[] original = { "h", "j", "all", "t", "c", "green" };
    String[] expected = { "all", "c", "green", "h", "j", "t" };
    sorter.sort(original, (x, y) -> x.compareTo(y));
    assertArrayEquals(original, expected);
  } // charsWords

} // class SortTester
