package com.clouway.threads.thread5;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TimeoutRemoverMain {
  public static void main(String[] args) {
    TimeoutHashTable timeoutHashTable = new TimeoutHashTable(3);
    Person person = new Person();
    Person person1 = new Person();

    timeoutHashTable.put("Ivan", person);
    try {
      Thread.sleep(2900);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    timeoutHashTable.put("Ivan", person1);
    System.out.println("==========");

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    System.out.println(timeoutHashTable.get("Ivan"));
  }

}
