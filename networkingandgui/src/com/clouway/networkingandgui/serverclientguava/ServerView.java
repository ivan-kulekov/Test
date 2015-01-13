package com.clouway.networkingandgui.serverclientguava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ServerView implements Display {
  private JFrame container = new JFrame();
  private JTextField port = new JTextField("4444");
  private JButton startServer = new JButton("Start");
  private JTextArea display = new JTextArea();
  private JButton stopServer = new JButton("Stop");

  public void initFrame(final Server server) {
    addElementsToFrame();
    container.setLayout(new GridLayout(0, 1, 2, 2));
    container.setSize(600, 300);
    container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    container.setVisible(true);

    ActionListener start = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        server.startAsync();
        server.awaitRunning();
      }
    };
    startServer.addActionListener(start);

    ActionListener stop = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          server.shutDown();
        } catch (Exception e1) {
          e1.printStackTrace();
        }
        server.awaitTerminated();
      }
    };
    stopServer.addActionListener(stop);
  }



  @Override
  public void show(String text) {
    display.append(text);
  }

  private void addElementsToFrame() {
    container.add(port);
    container.add(startServer);
    display.setEditable(false);
    container.add(display);
    container.add(stopServer);
  }
}
