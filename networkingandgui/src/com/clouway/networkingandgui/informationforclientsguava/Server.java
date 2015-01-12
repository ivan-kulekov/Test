package com.clouway.networkingandgui.informationforclientsguava;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Server extends AbstractExecutionThreadService {
  private Display display;
  private int clientCounter;
  private ServerSocket serverSocket;
  private List<Socket> clientList = new ArrayList<Socket>();

  public Server(Display display) {
    this.display = display;
  }

  public List<Socket> getClientList() {
    return clientList;
  }

  @Override
  protected void run() throws Exception {
    serverSocket = new ServerSocket(4444);
    while (isRunning()) {
      try {
        Socket clientSocket = serverSocket.accept();
        clientIncrease();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Your client number is: " + clientCounter);
        synchronized (clientList) {
          clientList.add(clientSocket);
        }
        display.show("Client number " + clientCounter + " has been connected!");
        if (clientList.size() > 1) {
          response();
        }
      } catch (SocketException e) {
        break;
      }
    }
  }

  private void response() throws IOException {
    for (Socket s : clientList) {
      PrintWriter out = new PrintWriter(s.getOutputStream(), true);
      out.println("Client with number " + clientCounter + " has been connected");
    }
  }

  @Override
  protected void shutDown() throws Exception {
    if (serverSocket != null) {
      serverSocket.close();
    }
    super.shutDown();

  }


  private void clientIncrease() {
    clientCounter++;
  }

  public int containerSize() {
    return clientList.size();
  }
}
