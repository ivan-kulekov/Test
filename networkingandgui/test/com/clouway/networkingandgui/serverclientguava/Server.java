package com.clouway.networkingandgui.serverclientguava;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Server extends AbstractExecutionThreadService {
  private final Display display;
  private ServerSocket serverSocket;
  public Server(Display display) {
    this.display = display;
  }

  @Override
  protected void run() {
    try {
      serverSocket = new ServerSocket(4444);
      DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
      Date date = new Date();
      while (isRunning()) {
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        display.show("Client has been connected");
        out.println("Hello " + dateFormat.format(date));
        clientSocket.close();
      }
    }catch (IOException e){
//      e.printStackTrace();
      System.out.println("asd");
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
