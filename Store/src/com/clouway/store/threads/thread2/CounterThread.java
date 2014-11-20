package com.clouway.store.threads.thread2;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class CounterThread extends Thread {
  private int countStop;
  private int count = 0;
  private CounterThread thread;


  public CounterThread(int countStop) {
    this.countStop = countStop;
  }

  public void setThread(CounterThread thread) {

    this.thread = thread;
  }

  public void run() {
    for (int i = 1; i <= countStop; i++) {
      if (Thread.interrupted()) {
        break;
      }
      System.out.println(thread.getName() + " says: " + i);
      count++;
      if (count == countStop){
        thread.interrupt();
      }
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }
    }
  }
}