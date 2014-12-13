package com.clouway.threads.thread4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by clouway on 14-9-23.
 */
public class ObjectContainer {
  private final int length;
  private int valueSet;
  private List<Integer> container = new ArrayList<Integer>();

  public ObjectContainer(int length) {
    this.length = length;
  }


  public synchronized void add(){
    if (valueSet == length){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    container.add(valueSet);
    System.out.println(Thread.currentThread().getName() +  " add: " + valueSet);
    valueSet++;
    notifyAll();
  }

  public synchronized void remove(){
    if (container.size() == 0){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    valueSet--;
    notifyAll();
    container.remove(valueSet);
    System.out.println(Thread.currentThread().getName() + " remove: " + valueSet);
  }
}
