package com.clouway.store.threads.thread5;

import java.util.Map;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Threads extends Thread {
  private int counterStop;
  private boolean reset;
  private final String key;
  private final Object value;
  private final Map<String, Object> timeOutHashTable;
  long startTime = System.nanoTime();
  private boolean isRemoved;

  public Threads(int counterStop, String key, Object value, Map<String, Object> timeOutHashTable) {
    this.counterStop = counterStop;
    this.key = key;
    this.value = value;
    this.timeOutHashTable = timeOutHashTable;
  }

  public void run() {
    int counter = counterStop;
    for (int i = 0; i < counterStop; i++) {
      if (!timeOutHashTable.containsKey(key) && !isRemoved) {
        timeOutHashTable.put(key, value);
      }
      if (reset) {
        counterStop += counter - i;
        reset = false;
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    timeOutHashTable.remove(key);
    long endTime = System.nanoTime();
    long duration = endTime - startTime;
    System.out.println(getName() + " Time " + duration);
  }

  public void reset() {
    reset = true;
  }
  public void isRemoved(){
    isRemoved = true;
  }
}
