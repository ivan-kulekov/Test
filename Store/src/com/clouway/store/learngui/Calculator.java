package com.clouway.store.learngui;

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
    if (operator.equals("")) {
      tempValueLeft += number;
      try {
        left = Double.parseDouble(tempValueLeft);
      }catch (NumberFormatException e){
        currentDisplay = "Error";
      }
    } else {
      tempValueRight += number;
      try {
        right = Double.parseDouble(tempValueRight);
      }catch (NumberFormatException e){
        currentDisplay = "Error";
      }
    }
    display.displayText(currentDisplay);
  }

  @Override
  public void operatorPressed(String operator) {
    this.operator = operator;
    if (!isOperatorUsed) {
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
    currentDisplay = currentDisplay.substring(0, currentDisplay.length() - 1);
    if (tempValueRight.equals("")) {
      tempValueLeft = tempValueLeft.substring(0, tempValueLeft.length() - 1);
      left = Integer.parseInt(tempValueLeft);
    } else {
      tempValueRight = tempValueRight.substring(0, tempValueRight.length() - 1);
      right = Integer.parseInt(tempValueRight);
    }
    display.displayText(currentDisplay);
  }

  @Override
  public void decimalPressed(String dot) {
    if (tempValueRight.equals("")){
      tempValueLeft += ".";
    }else {
      tempValueRight += ".";
    }
    currentDisplay += ".";
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
}
