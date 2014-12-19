package com.clouway.networkingandgui.server_client;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ServerMain {
  public static void main(String[] args) {
    Client client = new Client();
    Server server = new Server(client);
    server.startServer(4444);
//    try {
//      Thread.currentThread().sleep(5000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    server.stopServer();
  }

}
