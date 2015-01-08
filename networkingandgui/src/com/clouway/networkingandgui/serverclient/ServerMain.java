package com.clouway.networkingandgui.serverclient;

import com.clouway.networkingandgui.serverclient.view.ServerView;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ServerMain {
  public static void main(String[] args) {
    ServerView serverView = new ServerView();
    Server server = new Server(serverView);
    server.startServer(4444);
    server.startServer(4444);
//    try {
//      Thread.currentThread().sleep(5000);
//    } catch (InterruptedException e) {
//      e.printStackTrace();
//    }
//    server.stopServer();
  }

}
