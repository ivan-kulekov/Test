package com.clouway.collections.task2;

import java.util.Hashtable;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ExceptionsMessageManager {

  Hashtable<String, String> exceptions = new Hashtable<String, String>();

  public ExceptionsMessageManager(Hashtable<String, String> exceptions) {
    this.exceptions = exceptions;
  }

  public String registerErrorMessage(String messageCode, String message) {
    if (exceptions.containsValue(message)) {
      throw new IllegalArgumentException("There is a value with that message!");
    } else {
      exceptions.put(messageCode, message);
      return "The new key: '" + messageCode + "' with value: '" + message + "' are inserted to hash table.";
    }
  }

  public String raiseError(String messageCode) {
    if (!(exceptions.containsKey(messageCode))) {
      throw new IllegalArgumentException("The key is not correct, please enter correct key.");
    } else {
      return "The value with that key is: " + exceptions.get(messageCode);
    }
  }

  public String getErrorMessages() {
    return "The all error messages are: " + exceptions.values();
  }

}
