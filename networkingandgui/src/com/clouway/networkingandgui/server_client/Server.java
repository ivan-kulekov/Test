package com.clouway.networkingandgui.server_client;

import java.io.BufferedReader;
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
  private boolean stop;
  private boolean anotherClient;
  private Client client;
  private final Object lock = new Object();
  private ServerSocket serverSocket;
  private Socket clientSocket;

  public Server(Client client) {

  }

  public void startServer(final int port) {
    new Thread(new Runnable() {
      @Override
      public void run() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        try {
          serverSocket = new ServerSocket(port);
          stop = false;
          while (serverSocket.isBound()) {

            clientSocket = serverSocket.accept();
//            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            out.println("Hello. The server's date is: " + dateFormat.format(date));
          }
        } catch (IOException e) {
//          e.printStackTrace();
        }
      }
    }).start();

  }

  public void stopServer() {
    stop = true;
    try {
      PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
      out.println("The server is stopped!");
      serverSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

//    synchronized (lock) {

//      lock.notifyAll();
//    }


//            synchronized (lock) {
//              if (!stop) {
//                try {
//                  lock.wait();
//                } catch (InterruptedException e) {
//                  e.printStackTrace();
//                }
//              }
//            }

//            System.out.println("message");
//            out.println("the server is down!");
//            System.out.println(in.readLine());
}
