package com.clouway.networkingandgui.informationforclients;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Server {
  private ServerSocket serverSocket;
  private Display display;
  private int clientCounter;
  private Map<Integer, Socket> clientContainer = new HashMap<Integer, Socket>();

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
              clientContainer.put(clientCounter, clientSocket);
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

  public int clientContainerSize() {
    return clientContainer.size();
  }
}
