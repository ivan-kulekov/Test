package com.clouway.networkingandgui.calculator;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public interface CalculatorListener {
  void numberPressed(String text);
  void operatorPressed(String text);

  double findResult();

  void clearAll();

  void clear();

  void decimalPressed(String dot);
}
