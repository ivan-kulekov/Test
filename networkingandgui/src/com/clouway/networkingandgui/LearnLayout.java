package com.clouway.networkingandgui;

import javax.swing.*;
import java.awt.*;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class LearnLayout {
  private JFrame container = new JFrame();
  private JProgressBar progressBar = new JProgressBar();
  private JButton download = new JButton("Download");
  private JButton cancel = new JButton("Cancel");
  private JTextField url, fileNameInput;
  private JLabel urlLabel = new JLabel("Please enter URL: ");
  private JLabel fileName = new JLabel("Please enter file name:  ");
  private JLabel progress = new JLabel("Progress: ");


  public void initFrame(){
    url = new JTextField("", 60);
    fileNameInput = new JTextField("", 20);
    progressBar.setBorderPainted(true);
    progressBar.setStringPainted(true);
    container.add(urlLabel);
    container.add(url);
    container.add(fileName);
    container.add(fileNameInput);
    container.add(cancel);
    container.add(download);
    container.add(progress);
    container.add(progressBar);
    container.setLayout(new GridLayout(0, 2, 2, 2));
    container.setSize(700, 200);
    container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    container.setVisible(true);
  }
}
