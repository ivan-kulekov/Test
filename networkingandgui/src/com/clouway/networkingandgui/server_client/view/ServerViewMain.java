package com.clouway.networkingandgui.server_client.view;

import com.clouway.networkingandgui.server_client.Client;
import com.clouway.networkingandgui.server_client.Server;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ServerViewMain {
  public static void main(String[] args) {
    Client client = new Client();
    Server server = new Server(client);
    ServerView serverView = new ServerView();
    serverView.initFrame(server);
  }

}
