package com.clouway.networkingandgui.downloadagent;

import javax.swing.*;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class UIThread extends Thread {

  private final DownloadListener listener;
  private final JProgressBar progressBar;
  private final DownloadThread downloadThread;
  private final JButton cancel;
  private final JButton download;
  private final JTextField url;
  private final JTextField fileName;

  public UIThread(DownloadListener listener, DownloadThread downloadThread) {
    this.downloadThread = downloadThread;
    this.listener = listener;

    this.progressBar = new JProgressBar();
    this.cancel = new JButton("Cancel");
    this.download = new JButton("Download");
    this.url = new JTextField();
    this.fileName = new JTextField();
  }

  public void run() {
//    while (listener.getForProgressBar() == 0){
//      System.out.println();
//    }
//    progressBar.setMaximum(listener.getForProgressBar());
//    System.out.println(downloadThread.isDead() + "asd");
    while (!downloadThread.isDead()) {
//      System.out.println(listener.getForProgressBar() + " qwe");
      progressBar.setValue(listener.getTransferredBytes());
    }
    if (progressBar.getPercentComplete() == 1.0) {
      cancel.setVisible(false);
      download.setVisible(true);
      fileName.setEditable(true);
      url.setEditable(true);
    }
  }
}
