package com.clouway.store.threads.thread2;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ThreadMain {
  public static void main(String[] args) {
      CounterThread t1 = new CounterThread(4);
      CounterThread t2 = new CounterThread(5000);

    t1.setThread(t2);
    t2.setThread(t1);

    t1.start();
    t2.start();
  }
}
