package com.clouway.store.threads.thread4;

/**
 * Created by clouway on 14-9-23.
 */
public class ObjectContainer {
  private int size;
  private Object[] array;
  private int valueSet;

  public ObjectContainer(int length) {
    this.array = new Object[length];
  }

  public void printElements() {
    if (size < 1) {
      System.out.println("The array is empty!");
    }

    for (Object o : array) {
      if (o != null) {
        System.out.println(o);
      }
    }
  }

  public synchronized Object[] add(){
     if (valueSet >= array.length){
       try {
         wait();
       } catch (InterruptedException e) {
         e.printStackTrace();
       }
     }
    valueSet++;
    notifyAll();
    System.out.println("add: " + valueSet);
    return array;
  }

  public synchronized Object[] remove(){
    if (valueSet <= 0){
      try {
        wait();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    valueSet--;
    notifyAll();
    System.out.println("remove: " + valueSet);
    return array;
  }
}
