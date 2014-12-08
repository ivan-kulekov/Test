package com.clouway.store.threads.thread5;

import java.util.Hashtable;
import java.util.Map;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TimeoutHashTable {
  private int counter;
  private int timeOut;
  private Map<String, Object> timeOutHashTable = new Hashtable<String, Object>();
  TimeoutRemover thread;


  public TimeoutHashTable(int timeOut) {
    this.timeOut = timeOut;
  }

  public synchronized void put(String key, Object value) {
    thread = new TimeoutRemover(timeOut, key, value, timeOutHashTable);
//    if (timeOutHashTable.containsKey(key)) {
//      thread.reset();
//      counter++;
//    }
    timeOutHashTable.put(key, value);
    System.out.println("Size of TimeoutHashTable is: " + timeOutHashTable.size());
    thread.start();
  }

  public String remove(String key) {
    if (!timeOutHashTable.containsKey(key)) {
      return null;
    }
    timeOutHashTable.remove(key);
    thread.isRemoved();
    return "Remove - Done!";
  }

  public String get(String key) {
    if (!timeOutHashTable.containsKey(key)) {
      System.out.println("get NOT done!");
      return null;
    }
    thread.reset();
    timeOutHashTable.get(key);
    System.out.println("get done");
    return "Get - Done!";
  }
}
