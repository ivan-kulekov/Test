package com.clouway.collections.task2;


import java.util.Hashtable;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ExceptionsMessageManagerDemo {
  public static void main(String[] args) {
    Hashtable<String, String> exceptions = new Hashtable<String, String>();
    ExceptionsMessageManager messageManager = new ExceptionsMessageManager(exceptions);
    exceptions.put("error1", "Invalid number of debit card!");
    exceptions.put("error2", "Invalid PIN!");
    exceptions.put("error3", "Invalid post code!");

    messageManager.registerErrorMessage("error4", "Invalid security code!");

    System.out.println(messageManager.registerErrorMessage("error5", "Invalid name!"));
    System.out.println(messageManager.raiseError("error2"));
    System.out.println(messageManager.getErrorMessages());

  }
}
