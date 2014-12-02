package com.clouway.store.learngui;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public interface CalculatorListener {
  void numberPressed(String text);
  void operatorPressed(String text);

  void findResult();
}
