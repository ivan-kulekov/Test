package com.clouway.networkingandgui.server_client;

import com.clouway.networkingandgui.server_client.view.Display;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class Server {
  private ServerSocket serverSocket;
  private Display display;
  private boolean isStarted = false;

  public Server(Display display) {
    this.display = display;
  }

  public void startServer(final int port) {
    if (isStarted) {
      throw new ServerAlreadyStartedException();
    }
    isStarted = true;
    new Thread(new Runnable() {
      @Override
      public void run() {

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        try {
          serverSocket = new ServerSocket(port);
          while (isStarted) {
            Socket clientSocket = serverSocket.accept();
            display.show(clientSocket.getInetAddress().toString());
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello. The server's date is: " + dateFormat.format(date));
          }
        } catch (IOException e) {
        }
      }
    }).start();
  }

  public void stopServer() {
    isStarted = false;
    try {
      if (serverSocket != null) {
        serverSocket.close();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
