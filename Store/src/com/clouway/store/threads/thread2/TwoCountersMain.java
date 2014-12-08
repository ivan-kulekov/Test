package com.clouway.store.threads.thread2;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TwoCountersMain {
  public static void main(String[] args) {
    TwoCounters t1 = new TwoCounters(2000);
    TwoCounters t2 = new TwoCounters(1500);

    t1.notice(t2);
    t2.notice(t1);

    t1.start();
    t2.start();
  }
}
