package com.clouway.store.learngui;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Main {
  public static void main(String[] args) {
    CalculatorUI calculatorUI = new CalculatorUI();
    Calculator calculator = new Calculator(calculatorUI);
    calculatorUI.initFrame(calculator);
  }
}
