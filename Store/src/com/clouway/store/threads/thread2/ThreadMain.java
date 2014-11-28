package com.clouway.store.threads.thread2;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ThreadMain {
  public static void main(String[] args) {
    ThreadCounter t1 = new ThreadCounter(2000);
    ThreadCounter t2 = new ThreadCounter(1500);

    t1.notice(t2);
    t2.notice(t1);

    t1.start();
    t2.start();
  }
}
