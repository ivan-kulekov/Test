package com.clouway.networkingandgui.downloadagent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DownloadAgentView {
  private JFrame container = new JFrame();
  private JProgressBar progressBar = new JProgressBar();
  private JButton download = new JButton("Download");
  private JButton cancel = new JButton("Cancel");
  private JTextField url, fileNameInput;
  private JLabel labelUrl = new JLabel("Enter urlName Address: ");
  private JLabel fileNamePrompt = new JLabel("Enter the name of the file: ");
  private JLabel progress = new JLabel("Progress: ");

  private String urlName, downloadedFileName;

  public void initFrame(DownloadListener downloadListener) {
    addElementsToFrame();
    container.setLayout(new GridLayout(0, 2, 2, 2));
    container.setSize(700, 200);
    container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    container.setVisible(true);

    ActionListener download = actionListenerForDownloadButton(downloadListener);
    this.download.addActionListener(download);

    ActionListener cancel = ActionListenerForCancelButton(downloadListener);
    this.cancel.addActionListener(cancel);


  }

  private void addElementsToFrame() {
    url = new JTextField("", 60);
//    url.setText("http://amydrewthompson.com/wp-content/uploads/2011/02/burnout_full1.jpg");
    fileNameInput = new JTextField("", 20);

    cancel.setEnabled(false);
    progressBar.setBorderPainted(true);
    progressBar.setStringPainted(true);

    container.add(labelUrl);
    container.add(url);
    container.add(fileNamePrompt);
    container.add(fileNameInput);
    container.add(cancel);
    container.add(download);
    container.add(progress);
    container.add(progressBar);
  }


  private ActionListener actionListenerForDownloadButton(final DownloadListener downloadListener) {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        downloadedFileName = fileNameInput.getText();
        urlName = url.getText();

        url.setEditable(false);
        fileNameInput.setEditable(false);
        cancel.setEnabled(true);
        download.setEnabled(false);

        DownloadThread downloadThread = new DownloadThread(downloadListener, urlName, downloadedFileName);

        ProgressBarThread progressBarThread = new ProgressBarThread(downloadListener, downloadThread, progressBar);

        downloadThread.start();
        progressBarThread.start();

      }
    };

  }

  private ActionListener ActionListenerForCancelButton(final DownloadListener downloadListener) {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        downloadListener.isInterrupted();
        download.setEnabled(true);
        cancel.setEnabled(false);
        fileNameInput.setEditable(true);
        url.setEditable(true);
      }
    };
  }
}
