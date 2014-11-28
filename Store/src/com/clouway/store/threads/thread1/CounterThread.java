package com.clouway.store.threads.thread1;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class CounterThread extends Thread {
  private  boolean isShutDown = false;
  private int stopCounter;

  public CounterThread(int stopCounter) {
    this.stopCounter = stopCounter;
  }

  public void run() {

    System.out.print("Please enter the stop symbol from keyboard: ");
    for (int i = 1; i <= stopCounter; i++) {
      if (isShutDown) {
        System.out.println("The thread count to: " + i);
        break;
      }
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
          e.printStackTrace();
      }
    }
  }
  public void shutDown(){
    isShutDown = true;
  }
}
