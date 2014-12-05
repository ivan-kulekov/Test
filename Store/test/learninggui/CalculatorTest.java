package learninggui;

import com.clouway.store.learngui.Calculator;
import com.clouway.store.learngui.Display;
import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


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
  public void setUp() {
    calculator = new Calculator(display);
  }

  @Test
  public void oneNumberIsPressed() throws Exception {
    context.checking(new Expectations() {{
      oneOf(display).displayText("5");
    }});
    calculator.numberPressed("5");
  }

  @Test
  public void twoNumbersArePressed() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("5");
      oneOf(display).displayText("59");
    }});

    calculator.numberPressed("5");
    calculator.numberPressed("9");
  }

  @Test
  public void numberOperatorNumberArePressed() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("5");
      oneOf(display).displayText("5+");
      oneOf(display).displayText("5+8");
    }});
    calculator.numberPressed("5");
    calculator.operatorPressed("+");
    calculator.numberPressed("8");
  }

  @Test
  public void anotherNumberOperatorNumberArePressed() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("5");
      oneOf(display).displayText("5*");
      oneOf(display).displayText("5*8");
    }});
    calculator.numberPressed("5");
    calculator.operatorPressed("*");
    calculator.numberPressed("8");
  }

  @Test
  public void addMoreOperatorsThanOne(){
    context.checking(new Expectations() {{
      oneOf(display).displayText("5");
      oneOf(display).displayText("5*");
      oneOf(display).displayText("5*");
      oneOf(display).displayText("5*");
      oneOf(display).displayText("5*8");
    }});
    calculator.numberPressed("5");
    calculator.operatorPressed("*");
    calculator.operatorPressed("*");
    calculator.operatorPressed("*");
    calculator.numberPressed("8");
  }
  @Test
  public void sumOfTwoNumbers() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("5");
      oneOf(display).displayText("5+");
      oneOf(display).displayText("5+8");
      oneOf(display).displayText("13.0");
    }});
    calculator.numberPressed("5");
    calculator.operatorPressed("+");
    calculator.numberPressed("8");
    assertThat(calculator.findResult(), is(13.0));
  }

  @Test
  public void anotherSumOfTwoNumbers() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("5");
      oneOf(display).displayText("54");
      oneOf(display).displayText("54+");
      oneOf(display).displayText("54+8");
      oneOf(display).displayText("54+88");
      oneOf(display).displayText("142.0");
    }});
    calculator.numberPressed("5");
    calculator.numberPressed("4");
    calculator.operatorPressed("+");
    calculator.numberPressed("8");
    calculator.numberPressed("8");
    assertThat(calculator.findResult(), is (142.0));
  }

  @Test
  public void sumOfTwoNumbersAfterThatEqualsIsPressedAndAgainSumOfTwoNumbers() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("5");
      oneOf(display).displayText("5+");
      oneOf(display).displayText("5+8");
      oneOf(display).displayText("13.0");
      oneOf(display).displayText("6");
      oneOf(display).displayText("6+");
      oneOf(display).displayText("6+9");
      oneOf(display).displayText("15.0");
    }});

    calculator.numberPressed("5");
    calculator.operatorPressed("+");
    calculator.numberPressed("8");
    assertThat(calculator.findResult(), is(13.0));
    calculator.numberPressed("6");
    calculator.operatorPressed("+");
    calculator.numberPressed("9");
    assertThat(calculator.findResult(), is(15.0));
  }

  @Test
  public void subtractTwoNumbers() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("8");
      oneOf(display).displayText("8-");
      oneOf(display).displayText("8-5");
      oneOf(display).displayText("3.0");
    }});
    calculator.numberPressed("8");
    calculator.operatorPressed("-");
    calculator.numberPressed("5");
    assertThat(calculator.findResult(), is(3.0));
  }

  @Test
  public void subtractTwoNumbersThenPressEqualsAndAgainSubtractTwoNumbers(){
    context.checking(new Expectations() {{
      oneOf(display).displayText("8");
      oneOf(display).displayText("8-");
      oneOf(display).displayText("8-5");
      oneOf(display).displayText("3.0");
      oneOf(display).displayText("2");
      oneOf(display).displayText("25");
      oneOf(display).displayText("25-");
      oneOf(display).displayText("25-9");
      oneOf(display).displayText("16.0");
    }});
    calculator.numberPressed("8");
    calculator.operatorPressed("-");
    calculator.numberPressed("5");
    assertThat(calculator.findResult(), is(3.0));
    calculator.numberPressed("2");
    calculator.numberPressed("5");
    calculator.operatorPressed("-");
    calculator.numberPressed("9");
    assertThat(calculator.findResult(), is(16.0));
  }

  @Test
  public void multiplyTwoNumbers(){
    context.checking(new Expectations() {{
      oneOf(display).displayText("6");
      oneOf(display).displayText("6*");
      oneOf(display).displayText("6*5");
      oneOf(display).displayText("30.0");
    }});
    calculator.numberPressed("6");
    calculator.operatorPressed("*");
    calculator.numberPressed("5");
    assertThat(calculator.findResult(), is(30.0));
  }

  @Test
  public void divideTwoNumbers(){
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("30");
      oneOf(display).displayText("30/");
      oneOf(display).displayText("30/1");
      oneOf(display).displayText("30/15");
      oneOf(display).displayText("2.0");
    }});
    calculator.numberPressed("3");
    calculator.numberPressed("0");
    calculator.operatorPressed("/");
    calculator.numberPressed("1");
    calculator.numberPressed("5");
    assertThat(calculator.findResult(), is(2.0));
  }

  @Test
  public void buttonClearAllIsPressed(){
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("30");
      oneOf(display).displayText("30/");
      oneOf(display).displayText("30/1");
      oneOf(display).displayText("30/15");
      oneOf(display).displayText("");
    }});
    calculator.numberPressed("3");
    calculator.numberPressed("0");
    calculator.operatorPressed("/");
    calculator.numberPressed("1");
    calculator.numberPressed("5");
    calculator.clearAll();
  }
  
  @Test
  public void sumTwoNumbersAfterClearAllButtonIsPressed(){
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("30");
      oneOf(display).displayText("30/");
      oneOf(display).displayText("30/1");
      oneOf(display).displayText("30/15");
      oneOf(display).displayText("");
      oneOf(display).displayText("8");
      oneOf(display).displayText("8+");
      oneOf(display).displayText("8+7");
      oneOf(display).displayText("15.0");

    }});
    calculator.numberPressed("3");
    calculator.numberPressed("0");
    calculator.operatorPressed("/");
    calculator.numberPressed("1");
    calculator.numberPressed("5");
    calculator.clearAll();
    calculator.numberPressed("8");
    calculator.operatorPressed("+");
    calculator.numberPressed("7");
    assertThat(calculator.findResult(), is(15.0));
  }

  @Test
  public void buttonClearIsPressed(){
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("30");
      oneOf(display).displayText("30/");
      oneOf(display).displayText("30/1");
      oneOf(display).displayText("30/15");
      oneOf(display).displayText("30/1");
    }});
    calculator.numberPressed("3");
    calculator.numberPressed("0");
    calculator.operatorPressed("/");
    calculator.numberPressed("1");
    calculator.numberPressed("5");
    calculator.clear();
  }

  @Test
  public void sumTwoNumbersAfterClearButtonIsPressed(){
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("30");
      oneOf(display).displayText("30+");
      oneOf(display).displayText("30+1");
      oneOf(display).displayText("30+15");
      oneOf(display).displayText("30+1");
      oneOf(display).displayText("31.0");
    }});
    calculator.numberPressed("3");
    calculator.numberPressed("0");
    calculator.operatorPressed("+");
    calculator.numberPressed("1");
    calculator.numberPressed("5");
    calculator.clear();
    assertThat(calculator.findResult(), is(31.0));
  }
  
  @Test
  public void pressClearMoreThanNecessary(){
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("30");
      oneOf(display).displayText("305");
      oneOf(display).displayText("30");
      oneOf(display).displayText("3");
      oneOf(display).displayText("");
      oneOf(display).displayText("");
    }});
    calculator.numberPressed("3");
    calculator.numberPressed("0");
    calculator.numberPressed("5");
    calculator.clear();
    calculator.clear();
    calculator.clear();
    calculator.clear();
  }

//  @Test
//  public void pressButton0MoreThanOnceAtBeginning(){
//    context.checking(new Expectations() {{
//      oneOf(display).displayText("0");
//      oneOf(display).displayText("0");
//      oneOf(display).displayText("0");
//    }});
//    calculator.numberPressed("0");
//    calculator.numberPressed("0");
//    calculator.numberPressed("0");
//  }


  @Test
  public void sumOfTwoDecimalNumbers(){
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("3.");
      oneOf(display).displayText("3.2");
      oneOf(display).displayText("3.2+");
      oneOf(display).displayText("3.2+1");
      oneOf(display).displayText("3.2+1.");
      oneOf(display).displayText("3.2+1.5");
      oneOf(display).displayText("4.7");
    }});
    calculator.numberPressed("3");
    calculator.decimalPressed(".");
    calculator.numberPressed("2");
    calculator.operatorPressed("+");
    calculator.numberPressed("1");
    calculator.decimalPressed(".");
    calculator.numberPressed("5");
    assertThat(calculator.findResult(), is(4.7));
  }

  @Test
  public void decimalInvalidInput(){
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("3.");
      oneOf(display).displayText("3..");
      oneOf(display).displayText("Error");

    }});
    calculator.numberPressed("3");
    calculator.decimalPressed(".");
    calculator.decimalPressed(".");
    calculator.numberPressed("2");
  }

  @Test
  public void pushClearButtonToChangeTheOperator(){
   context.checking(new Expectations(){{
     oneOf(display).displayText("3");
     oneOf(display).displayText("3+");
     oneOf(display).displayText("3");
     oneOf(display).displayText("3-");
   }});
    calculator.numberPressed("3");
    calculator.operatorPressed("+");
    calculator.clear();
    calculator.operatorPressed("-");
  }
}
