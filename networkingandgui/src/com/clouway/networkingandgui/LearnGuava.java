package com.clouway.networkingandgui;


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
public class LearnGuava extends AbstractExecutionThreadService {
  @Override
  protected void run() throws Exception {

    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date date = new Date();
    try {
      ServerSocket serverSocket = new ServerSocket(4444);
      while (isRunning()) {
        Socket clientSocket = serverSocket.accept();
        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("asd " + dateFormat.format(date));
        clientSocket.close();
      }
    }catch (IOException e){
      e.printStackTrace();
    }
  }

  @Override
  protected void shutDown() throws Exception {
    super.shutDown();
  }
}
