package com.clouway.store.threads.thread3;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ThreadMain {
  public static void main(String[] args) {
    ProducerThread thread1 = new ProducerThread(8);
    ConsumerThread thread2 = new ConsumerThread(8);

    thread1.start();
    thread2.start();
    Thread[] listOfThreads = new Thread[3];
    Thread.enumerate(listOfThreads);
    System.out.println(listOfThreads.length);
  }
}
