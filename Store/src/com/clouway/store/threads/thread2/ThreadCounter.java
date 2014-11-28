package com.clouway.store.threads.thread2;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ThreadCounter extends Thread {
  private int counterStop;
  private  ThreadCounter thread;


  public ThreadCounter(int counterStop) {
    this.counterStop = counterStop;
  }
  public void notice(ThreadCounter thread){
    this.thread = thread;
  }

  public void run(){
    for (int i = 1; i <= counterStop; i++){
      if (isInterrupted()){
        System.out.println("finished");
        break;
      }
      System.out.println(i);
    }
    thread.interrupt();
  }
}
