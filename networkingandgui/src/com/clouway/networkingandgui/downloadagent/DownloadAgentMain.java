package com.clouway.networkingandgui.downloadagent;


/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DownloadAgentMain {
  public static void main(String[] args) {
    DownloadAgentView downloadAgentView = new DownloadAgentView();
    DownloadAgent downloadAgent = new DownloadAgent(downloadAgentView);
    downloadAgentView.initFrame(downloadAgent);
  }
}
