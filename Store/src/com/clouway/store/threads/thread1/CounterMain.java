package com.clouway.store.threads.thread1;

import java.util.Scanner;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class CounterMain {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    Thread thread = new Thread(new Counter(100));

    thread.start();
    scanner.nextLine();
    thread.interrupt();



    new Thread(new Runnable() {
      @Override
      public void run() {

      }
    });

    new Thread() {
      @Override
      public void run() {

      }
    };
  }

  public static class AnotherThread extends Thread {
    @Override
    public void run() {
      super.run();
    }
  }

}
