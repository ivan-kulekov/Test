package com.clouway.store.threads.thread3;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Methods {
  private boolean valueSet;
  private int value;

  public synchronized void get(){
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

  public synchronized void put(int value){
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
