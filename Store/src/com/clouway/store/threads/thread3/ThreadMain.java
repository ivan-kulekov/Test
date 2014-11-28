package com.clouway.store.threads.thread3;





/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ThreadMain {
  public static void main(String[] args) {
    Methods method = new Methods();
    ProducerThread thread1 = new ProducerThread(method, 5);
    ConsumerThread thread2 = new ConsumerThread(method, 5);

    thread1.start();
    thread2.start();
  }
}
