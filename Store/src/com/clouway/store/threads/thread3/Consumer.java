package com.clouway.store.threads.thread3;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Consumer implements Runnable {
  Methods methods;
  private int counterStop;

  public Consumer(Methods methods, int counterStop) {
    this.methods = methods;
    this.counterStop = counterStop;
  }

  public void run() {

    for (int i = 0; i <= counterStop; i++) {
      methods.get();
    }
  }
}
