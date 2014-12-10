package com.clouway.networkingandgui.downloadagent;

import javax.swing.*;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ProgressBarThread extends Thread {

  private final DownloadListener listener;
  private final JProgressBar progressBar;
  private final DownloadThread downloadThread;

  public ProgressBarThread(DownloadListener listener, DownloadThread downloadThread, JProgressBar progressBar) {
    this.downloadThread = downloadThread;
    this.listener = listener;
    this.progressBar = progressBar;
  }

  public void run() {
    while (!downloadThread.isDead()) {

      progressBar.setMaximum(listener.getForProgressBar());

      progressBar.setValue(listener.getTransferredBytes());
    }
  }
}
