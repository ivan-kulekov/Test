package com.clouway.networkingandgui.serverclientguava;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ServerMain {
  public static void main(String[] args) {
    ServerView serverView = new ServerView();
    Server server = new Server(serverView, 4444);
    serverView.initFrame(server);
  }
}
