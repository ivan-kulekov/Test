package com.clouway.networkingandgui.downloadagent;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DownloadAgentView{
  private JFrame container = new JFrame();
  private JProgressBar progressBar = new JProgressBar();
  private JButton download = new JButton("Download");
  private JButton cancel = new JButton("Cancel");
  private JTextField url, fileNameInput;

  private String urlName, downloadedFileName;

  public void initFrame(DownloadListener downloadListener) {

    container.setSize(600, 150);
    container.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    container.add(setUrlAndProgressBarPanel());
    container.add(setDownloadedFileNameAndButtonPanel(downloadListener));

    container.setVisible(true);

    progressBar.setValue(0);
  }

  private JPanel setDownloadedFileNameAndButtonPanel(DownloadListener downloadListener) {
    JPanel panel = new JPanel();

    JLabel fileNamePrompt = new JLabel("Enter the name of the file: ");
    fileNameInput = new JTextField("", 20);

    panel.add(fileNamePrompt);
    panel.add(fileNameInput);
    panel.add(download);
    panel.add(cancel);

    cancel.setEnabled(false);

    ActionListener download = actionListenerForDownloadButton(downloadListener);
    this.download.addActionListener(download);
    ActionListener cancel = ActionListenerForCancelButton(downloadListener);
    this.cancel.addActionListener(cancel);
    return panel;
  }

  private JPanel setUrlAndProgressBarPanel() {
    JPanel panelUrlAndProgressBar = new JPanel();
    JLabel labelUrl = new JLabel("Enter urlName Address: ");
    panelUrlAndProgressBar.add(labelUrl);
    url = new JTextField("", 40);
    panelUrlAndProgressBar.add(url);
    progressBar.setBorderPainted(true);
    progressBar.setStringPainted(true);
    panelUrlAndProgressBar.add(progressBar);

    return panelUrlAndProgressBar;
  }

  private ActionListener actionListenerForDownloadButton(final DownloadListener downloadListener) {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        downloadedFileName = fileNameInput.getText();
        urlName = url.getText();
        DownloadThread downloadThread = new DownloadThread(downloadListener, urlName, downloadedFileName);
        UIThread UIThread = new UIThread(downloadListener, downloadThread);
        downloadThread.start();
        url.setEditable(false);
        fileNameInput.setEditable(false);
        cancel.setVisible(true);
        download.setVisible(false);
        System.out.println(downloadListener.getForProgressBar());
        progressBar.setMaximum(downloadListener.getForProgressBar());
        UIThread.start();

      }
    };

  }

  private ActionListener ActionListenerForCancelButton(final DownloadListener downloadListener) {
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        downloadListener.isDead();
        download.setVisible(true);
        cancel.setVisible(false);
        fileNameInput.setEditable(true);
        url.setEditable(true);
      }
    };
  }
}
