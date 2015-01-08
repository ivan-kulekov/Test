package com.clouway.networkingandgui.downloadagent;

import javax.swing.*;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class ProgressBarThread extends Thread {

//  private final DownloadListener listener;
//  private final JProgressBar progressBar;
//  private final DownloadThread downloadThread;
//
//  public ProgressBarThread(DownloadListener listener, DownloadThread downloadThread, JProgressBar progressBar) {
//    this.downloadThread = downloadThread;
//    this.listener = listener;
//    this.progressBar = progressBar;
//  }
//
//  public void run() {
//    if (listener.getForProgressBar() == 0) {
//      try {
//        sleep(550);
//      } catch (InterruptedException e) {
//        e.printStackTrace();
//      }
//    }
//    progressBar.setMaximum(listener.getForProgressBar());
//    while (!downloadThread.isDead()) {
//      progressBar.setValue(listener.getTransferredBytes());
//
//    }
//  }
}
