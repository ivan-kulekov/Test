package com.clouway.threads.thread3;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ProducerConsumerMain {
  public static void main(String[] args) {

    SynchronizedCounter synchronizedCounter = new SynchronizedCounter();

    Thread producer = new Thread(new Counter(synchronizedCounter, 5));
    Thread consumer = new Thread(new CounterWaiter(synchronizedCounter, 5));

    producer.start();
    consumer.start();
  }
}
