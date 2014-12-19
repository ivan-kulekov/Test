package com.clouway.networkingandgui.server_client;


/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ClientMain {
  public static void main(String[] args) {
    Client client = new Client();
    client.connectClient("localhost", 4444);
//    try {
//      Thread.currentThread().sleep(2000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    client.disconnect();
  }
}
