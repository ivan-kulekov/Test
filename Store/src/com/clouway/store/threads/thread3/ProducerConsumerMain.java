package com.clouway.store.threads.thread3;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ProducerConsumerMain {
  public static void main(String[] args) {

    Methods method = new Methods();

    Thread producer = new Thread(new Producer(method, 5));
    Thread consumer = new Thread(new Consumer(method, 5));

    producer.start();
    consumer.start();
  }
}
