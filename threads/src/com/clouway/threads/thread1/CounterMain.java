package com.clouway.threads.thread1;

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
  }
}
