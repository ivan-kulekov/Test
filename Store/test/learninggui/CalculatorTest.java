package learninggui;

import com.clouway.store.learngui.Calculator;
import com.clouway.store.learngui.Display;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class CalculatorTest {
  Calculator calculator;
  @Rule
  public JUnitRuleMockery context = new JUnitRuleMockery();
  @Mock
  Display display;
  @Before
  public void setUp(){
    calculator = new Calculator(display);
  }

  @Test
  public void oneNumberIsPressed() throws Exception {
    context.checking(new Expectations(){{
      oneOf(display).displayText("5");
    }});
    calculator.numberPressed("5");
  }

  @Test
  public void twoNumbersArePressed(){
    context.checking(new Expectations(){{
      oneOf(display).displayText("5");
      oneOf(display).displayText("59");
    }});

    calculator.numberPressed("5");
    calculator.numberPressed("9");
  }

  @Test
  public void numberOperatorNumberArePressed(){
    context.checking(new Expectations(){{
      oneOf(display).displayText("5");
      oneOf(display).displayText("5+");
      oneOf(display).displayText("5+8");
    }});
    calculator.numberPressed("5");
    calculator.operatorPressed("+");
    calculator.numberPressed("8");
  }

  @Test
  public void anotherNumberOperatorNumberArePressed(){
    context.checking(new Expectations(){{
      oneOf(display).displayText("5");
      oneOf(display).displayText("5*");
      oneOf(display).displayText("5*8");
    }});
    calculator.numberPressed("5");
    calculator.operatorPressed("*");
    calculator.numberPressed("8");
  }

  @Test
  public void sumOfTwoNumbers(){
    context.checking(new Expectations(){{
      oneOf(display).displayText("5");
      oneOf(display).displayText("5+");
      oneOf(display).displayText("5+8");
      oneOf(display).displayText("13");
    }});
    calculator.numberPressed("5");
    calculator.operatorPressed("+");
    calculator.numberPressed("8");
    calculator.findResult();
  }
  
  @Test
  public void anotherSumOfTwoNumbers(){
    context.checking(new Expectations(){{
      oneOf(display).displayText("5");
      oneOf(display).displayText("54");
      oneOf(display).displayText("54+");
      oneOf(display).displayText("54+8");
      oneOf(display).displayText("54+88");
      oneOf(display).displayText("142");
    }});
    calculator.numberPressed("5");
    calculator.numberPressed("4");
    calculator.operatorPressed("+");
    calculator.numberPressed("8");
    calculator.numberPressed("8");
    calculator.findResult();
  }

  @Test
  public void sumOfTwoNumbersAfterEqualsIsPressed(){
    context.checking(new Expectations(){{
      oneOf(display).displayText("5");
      oneOf(display).displayText("5+");
      oneOf(display).displayText("5+8");
      oneOf(display).displayText("13");
      oneOf(display).displayText("6");
      oneOf(display).displayText("6+");
      oneOf(display).displayText("6+9");
      oneOf(display).displayText("15");
    }});

    calculator.numberPressed("5");
    calculator.operatorPressed("+");
    calculator.numberPressed("8");
    calculator.findResult();
    calculator.numberPressed("6");
    calculator.operatorPressed("+");
    calculator.numberPressed("9");
    calculator.findResult();
  }

}
