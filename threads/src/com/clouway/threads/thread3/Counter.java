package com.clouway.threads.thread3;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Counter implements Runnable {
  SynchronizedCounter synchronizedCounter;
  private int counterStop;

  public Counter(SynchronizedCounter synchronizedCounter, int counterStop) {
    this.synchronizedCounter = synchronizedCounter;
    this.counterStop = counterStop;
  }

  public void run() {

    for (int i = 0; i <= counterStop; i++) {
      synchronizedCounter.count(i);
    }
  }
}
