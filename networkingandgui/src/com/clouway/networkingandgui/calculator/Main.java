package com.clouway.networkingandgui.calculator;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Main {
  public static void main(String[] args) {
    CalculatorView calculatorView = new CalculatorView();
    Calculator calculator = new Calculator(calculatorView);
    calculatorView.initFrame(calculator);
  }
}
