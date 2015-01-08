package com.clouway.networkingandgui.serverclient.view;

import com.clouway.networkingandgui.serverclient.Server;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ServerViewMain {
  public static void main(String[] args) {

    ServerView serverView = new ServerView();
    Server server = new Server(serverView);
    serverView.initFrame(server);
  }

}
