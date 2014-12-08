package com.clouway.networkingandgui.downloadagent;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DownloadAgentMain {
  public static void main(String[] args) {
    DownloadAgentUI downloadAgent = new DownloadAgentUI();
    TransferObject transfer = new TransferObject();
    downloadAgent.initFrame(transfer);
  }
}
