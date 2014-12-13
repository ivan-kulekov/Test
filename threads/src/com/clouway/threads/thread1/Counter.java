package com.clouway.threads.thread1;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Counter implements Runnable {
  private int stopCounter;

  public Counter(int stopCounter) {
    this.stopCounter = stopCounter;
  }

  public void run() {

    System.out.print("Please enter the stop symbol from keyboard: ");
    for (int i = 1; i <= stopCounter; i++) {
      if (Thread.interrupted()) {
        System.out.println("The thread count to: " + i);
        break;
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
      }
    }
  }
}
