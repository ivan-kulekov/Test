package com.clouway.store.threads.thread3;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ConsumerThread extends Thread {
  private int counterStop;

  public ConsumerThread(int counterStop) {
    this.counterStop = counterStop;
  }

  public void run() {
    for (int i = 1; i <= counterStop; i++) {
      System.out.println(i);
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
