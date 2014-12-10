package com.clouway.networkingandgui.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class CalculatorView extends JFrame implements Display {
  private JTextField textField = new JTextField(15);
  private JButton buttonDecimal = new JButton(".");
  private JButton buttonEqual = new JButton("=");
  private JButton buttonClear = new JButton("C");
  private JButton buttonClearAll = new JButton("CE");
  private JButton invisibleButton = new JButton();
  private JButton anotherInvisibleButton = new JButton();
  private JButton[] digits = {new JButton("0"), new JButton("1"), new JButton("2"), new JButton("3"), new JButton("4"),
          new JButton("5"), new JButton("6"), new JButton("7"), new JButton("8"),
          new JButton("9")};
  private JButton[] operators = {new JButton("+"), new JButton("-"), new JButton("*"), new JButton("/")};


  public void initFrame(final CalculatorListener calculatorListener) {
    addButtonsInFrame();
    setLayout(new GridLayout(0, 3, 2, 2));
    setSize(400, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);

    numberListener(calculatorListener);
    operatorListener(calculatorListener);
    equalListener(calculatorListener);
    clearAllListener(calculatorListener);
    clearListener(calculatorListener);
    decimalListener(calculatorListener);
  }


  @Override
  public void displayText(String text) {
    textField.setText(text);
  }

  private void addButtonsInFrame() {
    add(anotherInvisibleButton).setVisible(false);
    add(textField);
    add(invisibleButton).setVisible(false);
    add(buttonClearAll);
    add(buttonClear);
    add(buttonEqual);
    for (JButton button : digits) {
      add(button);
    }
    add(buttonDecimal);
    for (JButton button : operators) {
      add(button);
    }
    textField.setEditable(false);
    textField.setText("");

  }


  private void equalListener(final CalculatorListener calculatorListener) {
    ActionListener equalListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        calculatorListener.findResult();
      }
    };
    buttonEqual.addActionListener(equalListener);
  }

  private void operatorListener(final CalculatorListener calculatorListener) {
    final ActionListener operatorListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (JButton operator : operators) {
          if (e.getSource() == operator) {
            calculatorListener.operatorPressed(operator.getText());
          }
        }
      }
    };
    for (JButton button : operators) {
      button.addActionListener(operatorListener);
    }
  }

  private void numberListener(final CalculatorListener calculatorListener) {
    ActionListener numberListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (JButton number : digits) {
          if (e.getSource() == number) {
            calculatorListener.numberPressed(number.getText());
          }
        }
      }
    };
    for (JButton button : digits) {
      button.addActionListener(numberListener);
    }
  }

  private void clearAllListener(final CalculatorListener calculatorListener) {
    ActionListener clearAllListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        calculatorListener.clearAll();
      }
    };
    buttonClearAll.addActionListener(clearAllListener);
  }

  private void clearListener(final CalculatorListener calculatorListener) {
    ActionListener clearListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        calculatorListener.clear();
      }
    };
    buttonClear.addActionListener(clearListener);
  }

  private void decimalListener(final CalculatorListener calculatorListener) {
    ActionListener decimalListener = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        calculatorListener.decimalPressed(buttonDecimal.getText());
      }
    };
    buttonDecimal.addActionListener(decimalListener);
  }

}
