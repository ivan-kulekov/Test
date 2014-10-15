package com.clouway.collections.task2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ExceptionsMessageManager {

  private Map<String, String> exceptions = new HashMap<String, String>();
  private StringBuilder builder = new StringBuilder();



  public void registerErrorMessage(String messageCode, String message) {
    if (exceptions.containsValue(message)) {
      throw new IllegalArgumentException("There is a error with that message!");
    } else {
      exceptions.put(messageCode, message);
    }
  }

  public void raiseError(String messageCode) {
    if (!(exceptions.containsKey(messageCode))) {
      throw new IllegalArgumentException("The error is not correct, please enter correct error.");
    }
    builder.append(exceptions.get(messageCode)).append("\n");
  }

  public String getErrorMessages() {
    return builder.toString();
  }

}
