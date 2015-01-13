package com.clouway.networkingandgui.serverclientguava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ClientView implements Display {
  private JFrame container = new JFrame();
  private JTextField localhost = new JTextField("localhost");
  private JTextField port = new JTextField("4444");
  private JButton connectClient = new JButton("Connect");
  private JTextArea display = new JTextArea();

  public void initFrame(final Client client) {
    addElementsToFrame();
    container.setLayout(new GridLayout(0, 1, 2, 2));
    container.setSize(600, 300);
    container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    container.setVisible(true);

    ActionListener connect = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        client.startAsync();
      }
    };
    connectClient.addActionListener(connect);
  }


  @Override
  public void show(String text) {
    display.append(text);
  }

  private void addElementsToFrame() {
    container.add(localhost);
    container.add(port);
    container.add(connectClient);
    display.setEditable(false);
    container.add(display);
  }
}
