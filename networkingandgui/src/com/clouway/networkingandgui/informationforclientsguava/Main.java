package com.clouway.networkingandgui.informationforclientsguava;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Main {
  public static void main(String[] args) {
    Display display = new Display() {
      @Override
      public void show(String text) {

      }
    };
    Server server = new Server(display);
    Client client = new Client(display, "localhost", 4444, server.getClientList());
    server.startAsync();
    server.awaitRunning();

  }
}
