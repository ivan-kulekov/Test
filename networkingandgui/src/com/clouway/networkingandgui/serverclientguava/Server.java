package com.clouway.networkingandgui.serverclientguava;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Server extends AbstractExecutionThreadService {
  private final Display display;
  private final int port;
  private ServerSocket serverSocket;
  public Server(Display display, int port) {
    this.display = display;
    this.port = port;
  }

  @Override
  protected void run() {
    try {
      serverSocket = new ServerSocket(port);
      Calendar date = Calendar.getInstance();
      while (isRunning()) {
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        display.show("Client has been connected" + "\n");
        out.println("Hello, the date is:  " + date.getTime());
        clientSocket.close();
      }
    }catch (IOException e){
//      e.printStackTrace();
//      System.out.println("asd");
    }
  }

  @Override
  protected void shutDown() throws Exception {
    if (serverSocket != null){
      serverSocket.close();
    }
    super.shutDown();
  }
}
