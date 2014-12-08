package com.clouway.store.learngui.calculator;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Calculator implements CalculatorListener {
  private String currentDisplay = "";
  private double left;
  private double right;
  private String operator = "";
  private double result = 0;
  private String tempValueLeft = "";
  private String tempValueRight = "";
  private boolean isOperatorUsed;

  private final Display display;

  public Calculator(Display display) {
    this.display = display;
  }

  public void numberPressed(String number) {
    currentDisplay += number;
    if (operator.isEmpty()) {
      tempValueLeft += number;
      try {
        left = Double.parseDouble(tempValueLeft);
      } catch (NumberFormatException e) {
        currentDisplay = "Error";
      }
    } else {
      tempValueRight += number;
      try {
        right = Double.parseDouble(tempValueRight);
      } catch (NumberFormatException e) {
        currentDisplay = "Error";
      }
    }
    display.displayText(currentDisplay);
  }

  @Override
  public void operatorPressed(String operator) {
    if (!isOperatorUsed) {
      this.operator = operator;
      currentDisplay += this.operator;
    }
    display.displayText(currentDisplay);
    isOperatorUsed = true;
  }

  @Override
  public double findResult() {
    if (operator.equals("+")) {
      result = left + right;
    }
    if (operator.equals("-")) {
      result = left - right;
    }
    if (operator.equals("*")) {
      result = left * right;
    }
    if (operator.equals("/")) {
      result = left / right;
    }
    currentDisplay = String.valueOf(result);
    display.displayText(currentDisplay);
    resetValues();
    isOperatorUsed = false;
    return result;
  }

  @Override
  public void clearAll() {
    resetValues();
    display.displayText(currentDisplay);
    isOperatorUsed = false;
  }

  @Override
  public void clear() {
    try {
      currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
    } catch (StringIndexOutOfBoundsException e) {
      currentDisplay = "";
    }
    if (tempValueRight.isEmpty() && !isOperatorUsed) {
      clearFromLeftSide();
    } else {
      clearFromRightSide();
    }
    if (isOperatorUsed && tempValueRight.isEmpty()) {
      isOperatorUsed = false;
    }
    display.displayText(currentDisplay);
  }

  @Override
  public void decimalPressed(String dot) {
    if (tempValueRight.isEmpty()) {
      tempValueLeft += dot;
    } else {
      tempValueRight += dot;
    }
    currentDisplay += dot;
    display.displayText(currentDisplay);
  }


  private void resetValues() {
    currentDisplay = "";
    operator = "";
    tempValueLeft = "";
    tempValueRight = "";
    left = 0;
    right = 0;
  }

  private void clearFromLeftSide() {
    try {
      tempValueLeft = tempValueLeft.substring(0, tempValueLeft.length() - 1);
      left = Double.parseDouble(tempValueLeft);
    } catch (NumberFormatException e) {
      tempValueLeft = "";
    } catch (StringIndexOutOfBoundsException e) {
      tempValueLeft = "";
    }
  }

  private void clearFromRightSide() {
    try {
      tempValueRight = tempValueRight.substring(0, tempValueRight.length() - 1);
      right = Double.parseDouble(tempValueRight);
    } catch (NumberFormatException e) {
      tempValueRight = "";
    } catch (StringIndexOutOfBoundsException e) {
      tempValueRight = "";
    }
  }
}
