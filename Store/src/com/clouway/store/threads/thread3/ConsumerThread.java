package com.clouway.store.threads.thread3;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ConsumerThread extends Thread {
  Methods methods;
  private int counterStop;

  public ConsumerThread(Methods methods, int counterStop) {
    this.methods = methods;
    this.counterStop = counterStop;
  }

  public void run() {

    for (int i = 0; i <= counterStop; i++) {
      methods.get();
    }
  }
}
