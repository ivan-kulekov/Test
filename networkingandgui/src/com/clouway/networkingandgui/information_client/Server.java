package com.clouway.networkingandgui.information_client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Server {
  private ServerSocket serverSocket;
  private Display display;
  private int clientCounter;

  public Server(Display display) {
    this.display = display;
  }

  public void start(final int port) {
      new Thread(new Runnable() {
        @Override
        public void run() {
          try {
            serverSocket = new ServerSocket(port);
            while (true) {
              Socket clientSocket = serverSocket.accept();
              clientIncrease();
              display.show("Client number: " + clientCounter + " has been connected!");
              PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
              out.println("You are: " + clientCounter);
            }
          }catch (IOException e){
//            e.printStackTrace();
          }
        }
      }).start();
  }

  public void stop() {
    if (serverSocket != null) {
      try {
        serverSocket.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }
  private void clientIncrease(){
    clientCounter++;
  }
}
