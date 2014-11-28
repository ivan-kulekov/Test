package com.clouway.store.threads.thread4;



/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class RemoveElementsThread extends Thread {
  ObjectContainer objectContainer;
  private int countStop;

  public RemoveElementsThread(ObjectContainer objectContainer, int countStop) {
    this.objectContainer = objectContainer;
    this.countStop = countStop;
  }
  public void run(){

    for (int i = 1; i <= countStop; i++){
      objectContainer.remove();
    }
  }
}
