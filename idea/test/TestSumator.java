import com.clouway.InvalidInputException;
import com.clouway.task2.Sumator;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TestSumator {
  @Test
  public void sumatorSum() throws Exception {
    Sumator sumator = new Sumator();
    String x = sumator.sum("5", "6");
    int y = Integer.parseInt(x);
    assertThat(y, is (11));
  }

  @Test
  public void sumatorSum1() throws Exception {
    Sumator sumator = new Sumator();
    String x = sumator.sum("11", "29");
    int y = Integer.parseInt(x);
    assertThat(y, is (40));

  }

  @Test
  public void sumNegativeNumbers() throws Exception {
    Sumator sumator = new Sumator();
    String x = sumator.sum("-11", "-29");
    int y = Integer.parseInt(x);
    assertThat(y, is (-40));

  }

  @Test(expected = InvalidInputException.class)
  public void invalidInput() throws Exception {
    Sumator sumator = new Sumator();
    sumator.sum("5safsdghdfsghfg", "6");
  }

  @Test(expected = IllegalArgumentException.class)
  public void inputNull() throws Exception {
    Sumator sumator = new Sumator();
    sumator.sum("","");

  }

  @Test(expected = InvalidInputException.class)
  public void maxPositive() throws Exception {
    Sumator sumator = new Sumator();
    sumator.sum("223748345637357567456477", "2");

  }

  @Test(expected = InvalidInputException.class)
  public void maxNegative() throws Exception {
    Sumator sumator = new Sumator();
    sumator.sum("-223748364745645673577", "2");

  }
}
