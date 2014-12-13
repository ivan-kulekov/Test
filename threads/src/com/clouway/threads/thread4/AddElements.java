package com.clouway.threads.thread4;



/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class AddElements implements Runnable {
  ObjectContainer objectContainer;
  private int counterStop;

  public AddElements(ObjectContainer objectContainer, int counterStop) {
    this.objectContainer = objectContainer;
    this.counterStop = counterStop;
  }

  public void run(){
      for (int i = 1; i<= counterStop;i++){
        objectContainer.add();
      }

  }
}
