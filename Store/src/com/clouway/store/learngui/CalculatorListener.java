package com.clouway.store.learngui;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public interface CalculatorListener {
  void numberPressed(String text);
  void operatorPressed(String text);

  int findResult();

  void clearAll();

  void clear();


  void decimalPressed(String s);
}
