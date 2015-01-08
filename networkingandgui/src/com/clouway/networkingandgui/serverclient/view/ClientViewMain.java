package com.clouway.networkingandgui.serverclient.view;

import com.clouway.networkingandgui.serverclient.Client;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ClientViewMain {
  public static void main(String[] args) {
    ClientView clientView = new ClientView();
    Client client = new Client(clientView);
    clientView.initFrame(client);
  }
}
