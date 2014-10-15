package com.clouway.collections.task2;


import java.util.Hashtable;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ExceptionsMessageManagerDemo {
  public static void main(String[] args) {
    ExceptionsMessageManager messageManager = new ExceptionsMessageManager();

    messageManager.registerErrorMessage("error1", "Invalid number of debit card!");

    messageManager.registerErrorMessage("error2", "Invalid PIN!");

    messageManager.registerErrorMessage("error3", "Invalid post code!");

    messageManager.registerErrorMessage("error5", "Invalid name!");
    messageManager.raiseError("error1");
    messageManager.raiseError("error2");
    messageManager.raiseError("error3");
    System.out.println(messageManager.getErrorMessages());

  }
}
