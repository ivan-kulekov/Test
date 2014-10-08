package com.clouway.collections.task2;

import java.util.Hashtable;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ExceptionsMessageManager {


  public String registerErrorMessage(String messageCode, String message, Hashtable<String, String> exceptions) {
    if (exceptions.containsValue(message)) {
      throw new IllegalArgumentException("There is a value with that message!");
    } else {
      exceptions.put(messageCode, message);
      return "The new key: '" + messageCode + "' and value: '" + message + "' are inserted to hash table.";
    }
  }

  public String raiseError(String messageCode, Hashtable<String, String> exceptions) {
    if (!(exceptions.containsKey(messageCode))) {
      throw new IllegalArgumentException("The key is not correct, please enter correct key.");
    } else {
      return "The value with that key is: " + exceptions.get(messageCode);
    }
  }

  public String getErrorMessages(Hashtable<String, String> exceptions) {
    return "The all error messages are: " + exceptions.values();
  }

}
