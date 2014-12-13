package com.clouway.threads.thread4;


import com.sun.org.apache.xpath.internal.SourceTree;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class RemoveElements implements Runnable {
  ObjectContainer objectContainer;
  private int countStop;

  public RemoveElements(ObjectContainer objectContainer, int countStop) {
    this.objectContainer = objectContainer;
    this.countStop = countStop;
  }
  public void run(){

    for (int i = 1; i <= countStop; i++){
      objectContainer.remove();
    }
  }
}
