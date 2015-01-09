package com.clouway.networkingandgui.testing;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Server extends AbstractExecutionThreadService {
  private Display display;
  private int clientCounter;
  private ServerSocket serverSocket;
  private Map<Integer, Socket> clientContainer = new Hashtable<Integer, Socket>();

  public Server(Display display) {
    this.display = display;
  }

  @Override
  protected void run() throws Exception {
    int maxSizeOfClientsList;
    serverSocket = new ServerSocket(4444);
    while (isRunning()) {
      try {
        Socket clientSocket = serverSocket.accept();
        clientIncrease();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Your client number is: " + clientCounter);
        clientContainer.put(clientCounter, clientSocket);
        maxSizeOfClientsList = clientContainer.size();
        display.show("Client number " + clientCounter + " has been connected!");
      }catch (SocketException se){
        System.out.println("Socket was closed so exiting");
        break;
      }
    }
  }

  @Override
  protected void shutDown() throws Exception {
    if (serverSocket != null){
      serverSocket.close();
    }
    super.shutDown();

  }

  @Override
  protected void triggerShutdown() {
    super.triggerShutdown();
  }

  private void clientIncrease(){
    clientCounter++;
  }

  public int containerSize() {
    return clientContainer.size();
  }
}
