package com.clouway.networkingandgui.serverclient.view;

import com.clouway.networkingandgui.serverclient.Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ClientView implements Display{
  private JFrame container = new JFrame();
  private JTextField localhost = new JTextField("localhost");
  private JTextField port = new JTextField("4444");
  private JButton connectClient = new JButton("Connect");
  private JTextArea textArea = new JTextArea();
//  private JButton disconnectClient = new JButton("Disconnect");
  private String forLocalhost;
  private int forPort;

  public void initFrame(final Client client) {
    addElementsToFrame();
    container.setLayout(new GridLayout(0, 1, 2, 2));
    container.setSize(600, 300);
    container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    container.setVisible(true);
    ActionListener connect = new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        client.connectClient(forLocalhost, forPort);
        try {
          Thread.sleep(50);
        } catch (InterruptedException e1) {
          e1.printStackTrace();
        }
        textArea.append(client.getCurrentDisplay());
      }
    };
//    ActionListener disconnect = new ActionListener() {
//      @Override
//      public void actionPerformed(ActionEvent e) {
////        client.disconnect();
//      }
//    };
//    disconnectClient.addActionListener(disconnect);
    connectClient.addActionListener(connect);
  }

  private void addElementsToFrame() {
    container.add(localhost);
    container.add(port);
    container.add(connectClient);
    textArea.setEditable(false);
    container.add(textArea);
//    container.add(disconnectClient);
    forLocalhost = localhost.getText();
    forPort = Integer.parseInt( port.getText());
  }

  @Override
  public void show(String text) {
    textArea.append(text + "\n");
  }
}
