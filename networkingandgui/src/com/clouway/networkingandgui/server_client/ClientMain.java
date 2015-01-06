package com.clouway.networkingandgui.server_client;


import com.clouway.networkingandgui.server_client.view.ClientView;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ClientMain {
  public static void main(String[] args) {
    ClientView clientView = new ClientView();
    Client client = new Client(clientView);
    client.connectClient("localhost", 4444);
  }
}
