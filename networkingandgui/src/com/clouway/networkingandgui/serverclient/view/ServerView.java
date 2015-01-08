package com.clouway.networkingandgui.serverclient.view;

import com.clouway.networkingandgui.serverclient.Server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ServerView implements Display{
  private JFrame container = new JFrame();
  private JTextField port = new JTextField("4444");
  private JButton setParamsToServer = new JButton("Start");
  private JTextArea textArea = new JTextArea();
  private JButton stopServer = new JButton("Stop");
  private int portNumber;

  public void initFrame(final Server server){
    addElementsToFrame();
    container.setLayout(new GridLayout(0, 1, 2, 2));
    container.setSize(600, 300);
    container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    container.setVisible(true);

    ActionListener start = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        server.startServer(portNumber);
//        textArea.setText("Server was started.\n");
      }
    };
    ActionListener stop = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        server.stopServer();
//        textArea.append("Server was stopped.\n");
      }
    };
    setParamsToServer.addActionListener(start);
    stopServer.addActionListener(stop);
  }

  private void addElementsToFrame() {
    container.add(port);
    container.add(setParamsToServer);
    textArea.setEditable(false);
    container.add(textArea);
    container.add(stopServer);
    portNumber = Integer.parseInt(port.getText());
  }

  @Override
  public void show(String text) {
    textArea.append(text + "\n");
  }
}
