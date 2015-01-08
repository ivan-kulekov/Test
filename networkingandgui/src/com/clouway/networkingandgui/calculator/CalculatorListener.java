package com.clouway.networkingandgui.calculator;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public interface CalculatorListener {
  void onNumberPressed(int number);
  void onOperatorPressed(String text);

  double onEqualPressed();

  void onClearAllPressed();

  void onClearPressed();

  void onDecimalPressed(String dot);
}
