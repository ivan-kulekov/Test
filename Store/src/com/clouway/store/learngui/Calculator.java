package com.clouway.store.learngui;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Calculator implements CalculatorListener {
  private String currentDisplay = "";
  private int left;
  private int right;
  private String operator = "";
  private int result;
  private String tempValueLeft = "";
  private String tempValueRight = "";

  private final Display display;

  public Calculator(Display display) {
    this.display = display;
  }

  public void numberPressed(String number) {
    if (operator.equals("")) {
      tempValueLeft += number;
      left = Integer.parseInt(tempValueLeft);
    } else {
      tempValueRight += number;
      right = Integer.parseInt(tempValueRight);
    }
    currentDisplay += number;
    display.displayText(currentDisplay);
  }

  @Override
  public void operatorPressed(String operator) {
    this.operator = operator;
    currentDisplay += operator;
    display.displayText(currentDisplay);
  }

  @Override
  public void findResult() {
    if (operator.equals("+")) {
      result = left + right;
    }
    currentDisplay = String.valueOf(result);
    display.displayText(currentDisplay);
    resetValues();
  }

  private void resetValues() {
    currentDisplay = "";
    operator = "";
    tempValueLeft = "";
    tempValueRight = "";
    left = 0;
    right = 0;
//    result = 0;
  }
}
