package com.clouway.store.threads.thread4;



/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class AddElementsThread extends Thread {
  ObjectContainer objectContainer;
  private int counterStop;

  public AddElementsThread(ObjectContainer objectContainer, int counterStop) {
    this.objectContainer = objectContainer;
    this.counterStop = counterStop;
  }

  public void run(){
      for (int i = 1; i<= counterStop;i++){

        objectContainer.add();
      }

  }
}
