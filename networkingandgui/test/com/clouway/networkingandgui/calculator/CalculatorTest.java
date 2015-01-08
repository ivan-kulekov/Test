package com.clouway.networkingandgui.calculator;

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
    calculator.onNumberPressed(5);
  }

  @Test
  public void numberAfterNumber() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("6");
      oneOf(display).displayText("69");
    }});

    calculator.onNumberPressed(6);
    calculator.onNumberPressed(9);

  }

  @Test
  public void numberOperatorNumberArePressed() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("5");
      oneOf(display).displayText("5+");
      oneOf(display).displayText("5+8");
    }});
    calculator.onNumberPressed(5);
    calculator.onOperatorPressed("+");
    calculator.onNumberPressed(8);
  }

  @Test
  public void anotherNumberOperatorNumberArePressed() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("7");
      oneOf(display).displayText("7*");
      oneOf(display).displayText("7*8");
    }});
    calculator.onNumberPressed(7);
    calculator.onOperatorPressed("*");
    calculator.onNumberPressed(8);
  }

  @Test
  public void addMoreOperatorsThanOne() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("3*");
      oneOf(display).displayText("3*8");
    }});
    calculator.onNumberPressed(3);
    calculator.onOperatorPressed("*");
    calculator.onOperatorPressed("*");
    calculator.onOperatorPressed("*");
    calculator.onNumberPressed(8);
  }

  @Test
  public void sumOfTwoNumbers() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("5");
      oneOf(display).displayText("5+");
      oneOf(display).displayText("5+8");
      oneOf(display).displayText("13.0");
    }});
    calculator.onNumberPressed(5);
    calculator.onOperatorPressed("+");
    calculator.onNumberPressed(8);
    assertThat(calculator.onEqualPressed(), is(13.0));
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
    calculator.onNumberPressed(5);
    calculator.onNumberPressed(4);
    calculator.onOperatorPressed("+");
    calculator.onNumberPressed(8);
    calculator.onNumberPressed(8);
    assertThat(calculator.onEqualPressed(), is(142.0));
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

    calculator.onNumberPressed(5);
    calculator.onOperatorPressed("+");
    calculator.onNumberPressed(8);
    assertThat(calculator.onEqualPressed(), is(13.0));
    calculator.onNumberPressed(6);
    calculator.onOperatorPressed("+");
    calculator.onNumberPressed(9);
    assertThat(calculator.onEqualPressed(), is(15.0));
  }

  @Test
  public void subtractTwoNumbers() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("8");
      oneOf(display).displayText("8-");
      oneOf(display).displayText("8-5");
      oneOf(display).displayText("3.0");
    }});
    calculator.onNumberPressed(8);
    calculator.onOperatorPressed("-");
    calculator.onNumberPressed(5);
    assertThat(calculator.onEqualPressed(), is(3.0));
  }

  @Test
  public void subtractTwoNumbersThenPressEqualsAndAgainSubtractTwoNumbers() {
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
    calculator.onNumberPressed(8);
    calculator.onOperatorPressed("-");
    calculator.onNumberPressed(5);
    assertThat(calculator.onEqualPressed(), is(3.0));
    calculator.onNumberPressed(2);
    calculator.onNumberPressed(5);
    calculator.onOperatorPressed("-");
    calculator.onNumberPressed(9);
    assertThat(calculator.onEqualPressed(), is(16.0));
  }

  @Test
  public void multiplyTwoNumbers() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("6");
      oneOf(display).displayText("6*");
      oneOf(display).displayText("6*5");
      oneOf(display).displayText("30.0");
    }});
    calculator.onNumberPressed(6);
    calculator.onOperatorPressed("*");
    calculator.onNumberPressed(5);
    assertThat(calculator.onEqualPressed(), is(30.0));
  }

  @Test
  public void divideTwoNumbers() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("30");
      oneOf(display).displayText("30/");
      oneOf(display).displayText("30/1");
      oneOf(display).displayText("30/15");
      oneOf(display).displayText("2.0");
    }});
    calculator.onNumberPressed(3);
    calculator.onNumberPressed(0);
    calculator.onOperatorPressed("/");
    calculator.onNumberPressed(1);
    calculator.onNumberPressed(5);
    assertThat(calculator.onEqualPressed(), is(2.0));
  }

  @Test
  public void buttonClearAllIsPressed() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("30");
      oneOf(display).displayText("30/");
      oneOf(display).displayText("30/1");
      oneOf(display).displayText("30/15");
      oneOf(display).displayText("");
      oneOf(display).displayText("4");
    }});
    calculator.onNumberPressed(3);
    calculator.onNumberPressed(0);
    calculator.onOperatorPressed("/");
    calculator.onNumberPressed(1);
    calculator.onNumberPressed(5);
    calculator.onClearAllPressed();
    calculator.onNumberPressed(4);
  }

  @Test
  public void sumTwoNumbersAfterClearAllButtonIsPressed() {
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
    calculator.onNumberPressed(3);
    calculator.onNumberPressed(0);
    calculator.onOperatorPressed("/");
    calculator.onNumberPressed(1);
    calculator.onNumberPressed(5);
    calculator.onClearAllPressed();
    calculator.onNumberPressed(8);
    calculator.onOperatorPressed("+");
    calculator.onNumberPressed(7);
    assertThat(calculator.onEqualPressed(), is(15.0));
  }

  @Test
  public void buttonClearIsPressed() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("30");
      oneOf(display).displayText("30/");
      oneOf(display).displayText("30/1");
      oneOf(display).displayText("30/15");
      oneOf(display).displayText("30/1");
      oneOf(display).displayText("30.0");
    }});
    calculator.onNumberPressed(3);
    calculator.onNumberPressed(0);
    calculator.onOperatorPressed("/");
    calculator.onNumberPressed(1);
    calculator.onNumberPressed(5);
    calculator.onClearPressed();
    assertThat(calculator.onEqualPressed(), is(30.0));
  }

  @Test
  public void sumTwoNumbersAfterClearButtonIsPressed() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("30");
      oneOf(display).displayText("30+");
      oneOf(display).displayText("30+1");
      oneOf(display).displayText("30+15");
      oneOf(display).displayText("30+1");
      oneOf(display).displayText("31.0");
    }});
    calculator.onNumberPressed(3);
    calculator.onNumberPressed(0);
    calculator.onOperatorPressed("+");
    calculator.onNumberPressed(1);
    calculator.onNumberPressed(5);
    calculator.onClearPressed();
    assertThat(calculator.onEqualPressed(), is(31.0));
  }

  @Test
  public void pressClearMoreThanNecessary() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("30");
      oneOf(display).displayText("305");
      oneOf(display).displayText("30");
      oneOf(display).displayText("3");
      oneOf(display).displayText("");
      oneOf(display).displayText("");
      oneOf(display).displayText("5");
    }});
    calculator.onNumberPressed(3);
    calculator.onNumberPressed(0);
    calculator.onNumberPressed(5);
    calculator.onClearPressed();
    calculator.onClearPressed();
    calculator.onClearPressed();
    calculator.onClearPressed();
    calculator.onNumberPressed(5);
  }

  @Test
  public void sumOfTwoDecimalNumbers() {
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
    calculator.onNumberPressed(3);
    calculator.onDecimalPressed(".");
    calculator.onNumberPressed(2);
    calculator.onOperatorPressed("+");
    calculator.onNumberPressed(1);
    calculator.onDecimalPressed(".");
    calculator.onNumberPressed(5);
    assertThat(calculator.onEqualPressed(), is(4.7));
  }

  @Test
  public void decimalInvalidInput() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("3.");
      oneOf(display).displayText("3..");
      oneOf(display).displayText("Error");

    }});
    calculator.onNumberPressed(3);
    calculator.onDecimalPressed(".");
    calculator.onDecimalPressed(".");
    calculator.onNumberPressed(2);
  }

  @Test
  public void pushClearButtonToChangeTheOperator() {
    context.checking(new Expectations() {{
      oneOf(display).displayText("3");
      oneOf(display).displayText("3+");
      oneOf(display).displayText("3");
      oneOf(display).displayText("3-");
    }});
    calculator.onNumberPressed(3);
    calculator.onOperatorPressed("+");
    calculator.onClearPressed();
    calculator.onOperatorPressed("-");
  }

}
