package com.clouway.store.threads.thread1;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class CounterThread extends Thread {
  private  boolean shutDown = false;
  private int stopCounter;

  public CounterThread(int stopCounter) {
    this.stopCounter = stopCounter;
  }

  public void run() {

    System.out.print("Please enter the stop symbol from keyboard: ");
    for (int i = 1; i <= stopCounter; i++) {
      if (shutDown) {
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
  public void shutDown(){
    shutDown = true;
  }
}
