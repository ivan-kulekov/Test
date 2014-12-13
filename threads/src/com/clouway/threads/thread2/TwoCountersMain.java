package com.clouway.threads.thread2;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TwoCountersMain {
  public static void main(String[] args) {

    TwoCounters t0 = new TwoCounters(5);
    TwoCounters t1 = new TwoCounters(7);

    t0.notice(t1);
    t1.notice(t0);

    t0.start();
    t1.start();
  }
}
