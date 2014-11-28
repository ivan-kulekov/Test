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
  Threads threads;


  public TimeoutHashTable(int timeOut) {
    this.timeOut = timeOut;
  }

  public synchronized void put(String key, Object value) {
    threads = new Threads(timeOut, key, value, timeOutHashTable);
//    if (timeOutHashTable.containsKey(key)) {
//      threads.reset();
//      counter++;
//    }
    timeOutHashTable.put(key, value);
    System.out.println(timeOutHashTable.size());
    threads.start();
  }

  public String remove(String key) {
    if (!timeOutHashTable.containsKey(key)) {
      return null;
    }
    timeOutHashTable.remove(key);
    threads.isRemoved();
    return "Remove - Done!";
  }

  public String get(String key) {
    if (!timeOutHashTable.containsKey(key)) {
      System.out.println("get NOT done!");
      return null;
    }
    threads.reset();
    timeOutHashTable.get(key);
    System.out.println("get done");
    return "Get - Done!";
  }
}
