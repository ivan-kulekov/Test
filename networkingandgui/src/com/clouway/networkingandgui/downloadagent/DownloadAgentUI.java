package com.clouway.networkingandgui.downloadagent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DownloadAgentUI extends JFrame {
  private JProgressBar progressBar = new JProgressBar();
  private JButton buttonDownload = new JButton("Download");
  private JButton buttonCancel = new JButton("Cancel");
  private JTextField textFieldUrl, textFieldDownload;
  private JLabel labelUrl, labelDownload;
  private String urlName, downloadedFileName;
  private int progress = 0;
  private boolean downloadIsInterrupted;

  public void initFrame(DownloadListener downloadListener) {
    JPanel panelUrlAndProgressBar = setUrlAndProgressBarPanel();
    JPanel panelDownloadedFileNameAndButton = setDownloadedFileNameAndButtonPanel(downloadListener);
    setSize(600, 150);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    add(panelUrlAndProgressBar);
    panelUrlAndProgressBar.add(panelDownloadedFileNameAndButton);
    setVisible(true);
    progressBar.setValue(0);
  }

  private JPanel setDownloadedFileNameAndButtonPanel(DownloadListener downloadListener) {
    JPanel panelDownloadedFileNameAndButton = new JPanel();
    labelDownload = new JLabel("Enter the name of the file: ");
    panelDownloadedFileNameAndButton.add(labelDownload);
    textFieldDownload = new JTextField("", 20);

    panelDownloadedFileNameAndButton.add(textFieldDownload);
    panelDownloadedFileNameAndButton.add(buttonDownload);
    buttonDownload.setVisible(true);
    panelDownloadedFileNameAndButton.add(buttonCancel);
    buttonCancel.setVisible(false);
    ActionListener download = actionListenerForDownloadButton(downloadListener);
    buttonDownload.addActionListener(download);
    ActionListener cancel = ActionListenerForCancelButton(downloadListener);
    buttonCancel.addActionListener(cancel);
    return panelDownloadedFileNameAndButton;
  }

  private JPanel setUrlAndProgressBarPanel() {
    JPanel panelUrlAndProgressBar = new JPanel();
    labelUrl = new JLabel("Enter urlName Address: ");
    panelUrlAndProgressBar.add(labelUrl);
    textFieldUrl = new JTextField("", 40);
    panelUrlAndProgressBar.add(textFieldUrl);
    progressBar.setBorderPainted(true);
    progressBar.setStringPainted(true);
    panelUrlAndProgressBar.add(progressBar);

    return panelUrlAndProgressBar;
  }

  private ActionListener actionListenerForDownloadButton(final DownloadListener downloadListener) {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
//        urlName = textFieldUrl.getText();
        downloadedFileName = textFieldDownload.getText();
        try {
          buttonCancel.setVisible(true);
          buttonDownload.setVisible(false);
          URL url = new URL(textFieldUrl.getText());
          URLConnection connection = url.openConnection();
          InputStream in = connection.getInputStream();
          FileOutputStream outputStream = new FileOutputStream(downloadedFileName);
          progressBar.setMaximum(connection.getContentLength());
          DownloadThread downloadThread = new DownloadThread(downloadListener, in, outputStream);
          ProgressBarThread progressBarThread = new ProgressBarThread(downloadListener, progressBar, downloadThread);
          downloadThread.start();
          progressBarThread.start();
        } catch (MalformedURLException e1) {
          e1.printStackTrace();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
    };

  }

  private ActionListener ActionListenerForCancelButton(final DownloadListener downloadListener) {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        downloadListener.isDead();
        buttonDownload.setVisible(true);
        buttonCancel.setVisible(false);
      }
    };
  }
}
