import com.clouway.task2.Sumator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Test {
  @org.junit.Test
  public void sumatorSum() throws Exception {
    Sumator sumator = new Sumator();
    String x = sumator.sum("5", "6");
    int y = Integer.parseInt(x);
    assertThat(y, is (11));
  }

  @org.junit.Test(expected = NumberFormatException.class)
  public void invalidInput() throws Exception {
    Sumator sumator = new Sumator();
    String x = sumator.sum("5a", "6");
    int y = Integer.parseInt(x);
    assertThat(y, is (11));
  }

  @org.junit.Test(expected = NumberFormatException.class)
  public void inputNull() throws Exception {
    Sumator sumator = new Sumator();
    String x = sumator.sum("", "");
    int y = Integer.parseInt(x);
    assertThat(y, is (11));
  }

  @org.junit.Test(expected = NumberFormatException.class)
  public void maxInteger() throws Exception {
    Sumator sumator = new Sumator();
    String x = sumator.sum("21374836477", "2");
    int y = Integer.parseInt(x);
    assertThat(y, is (2137483647));

  }
}
