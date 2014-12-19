package com.clouway.networkingandgui.server_client.view;

import com.clouway.networkingandgui.server_client.Client;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ClientViewMain {
  public static void main(String[] args) {
    Client client = new Client();
    ClientView clientView = new ClientView();
    clientView.initFrame(client);
  }
}
