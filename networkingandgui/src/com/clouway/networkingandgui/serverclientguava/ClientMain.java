package com.clouway.networkingandgui.serverclientguava;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ClientMain {
  public static void main(String[] args) {
    ClientView clientView = new ClientView();
    Client client = new Client(clientView, "localhost", 4444);
    clientView.initFrame(client);
  }
}
