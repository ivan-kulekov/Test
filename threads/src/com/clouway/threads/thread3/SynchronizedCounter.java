package com.clouway.threads.thread3;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class SynchronizedCounter {
  private boolean valueSet;
  private int value;

  public synchronized void waitThenCount(){
    if (!valueSet){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    System.out.println(Thread.currentThread().getName() + " - " + value);
    valueSet = false;
    notifyAll();
  }

  public synchronized void count(int value){
    if (valueSet){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    this.value = value;
    valueSet = true;
    System.out.println(Thread.currentThread().getName() + " - " + value);
    notifyAll();
  }
}
