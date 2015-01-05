package com.clouway.networkingandgui.server_client.view;

import com.clouway.networkingandgui.server_client.Client;
import com.clouway.networkingandgui.server_client.Server;

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
