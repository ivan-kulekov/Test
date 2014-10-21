import com.clouway.task1.Array;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TestArray {
  @Test
  public void getMinElement() throws Exception {
    int[] arr = {1, 2, 3, 4, 5};
    Array array = new Array();
    int x = array.getMinElement(arr);
    assertThat(x, is(1));

  }
  @Test
  public void getMinElement1() throws Exception {
    int[] arr = {3, 56, 10, 27, 58};
    Array array = new Array();
    int x = array.getMinElement(arr);
    assertThat(x, is(3));

  }

  @Test(expected = ArrayIndexOutOfBoundsException.class)
  public void getMinElementNull() throws Exception {
    int[] arr = {};
    Array array = new Array();
    int x = array.getMinElement(arr);
    assertThat(x, is(0));
  }

  @Test
  public void getMinElementNegative() throws Exception {
    int[] arr = {1, 2, -1, -2, -100};
    Array array = new Array();
    int x = array.getMinElement(arr);
    assertThat(x, is(-100));
  }

  @Test
  public void getMinElementEquals() throws Exception {
    int[] arr = {1, 1, 1, 1, 1};
    Array array = new Array();
    int x = array.getMinElement(arr);
    assertThat(x, is(1));
  }

  @Test
  public void getSum() throws Exception {
    int[] arr = {1, 2, 3, 4, 5};
    Array array = new Array();
    int x = array.getSum(arr);
    assertThat(x, is(15));

  }

  @Test
  public void getSum1() throws Exception {
    int[] arr = {10, 20, 30, 40, 52};
    Array array = new Array();
    int x = array.getSum(arr);
    assertThat(x, is(152));

  }

  @Test
  public void getSumNull() throws Exception {
    int[] arr = {};
    Array array = new Array();
    int x = array.getSum(arr);
    assertThat(x, is(0));

  }

  @Test
  public void getSumNegative() throws Exception {
    int[] arr = {-2, -10, -20, -30};
    Array array = new Array();
    int x = array.getSum(arr);
    assertThat(x, is(-62));
  }

  @Test
  public void printArray() throws Exception {
    int[] arr = {2, 10, 20, 30};
    Array array = new Array();
    String s = array.printArray(arr);
    assertThat(s, is("2 10 20 30 "));

  }

  @Test
  public void printArray1() throws Exception {
    int[] arr = {28, 15, 22, 33};
    Array array = new Array();
    String s = array.printArray(arr);
    assertThat(s, is("28 15 22 33 "));

  }

  @Test
  public void printArrayNull() throws Exception {
    int[] arr = {};
    Array array = new Array();
    String s = array.printArray(arr);
    assertThat(s, is(""));

  }
}
