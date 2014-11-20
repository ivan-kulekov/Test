package com.clouway.store.threads.thread1;

import java.util.Scanner;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ThreadMain {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    CounterThread thread = new CounterThread(100);
    thread.start();
    scanner.nextLine();
    thread.shutDown();
  }
}
