package com.clouway.networkingandgui.calculator;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public interface CalculatorListener {
  String numberPressed(int number);
  void operatorPressed(String text);

  double findResult();

  void clearAll();

  void clear();

  void decimalPressed(String dot);
}
