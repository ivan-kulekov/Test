package com.clouway.networkingandgui.downloadagent;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DownloadAgentTest {

  @Rule
  public TemporaryFolder folder = new TemporaryFolder();

//  @Test
//  public void downloadPicture() throws IOException {
//    TransferObject transferObject = new TransferObject();
//    String urlName = "http://amydrewthompson.com/wp-content/uploads/2011/02/burnout_full1.jpg";
//    File tempFile = folder.newFile("asd.jpg");
//    transferObject.startDownload(urlName, tempFile.getAbsolutePath());
//    int fileSize = (int) tempFile.length();
//    assertThat(transferObject.getTransferredBytes(), is(fileSize));
//  }

//  @Test
//  public void download5MbFile() throws IOException {
//    TransferObject transferObject = new TransferObject();
//    String urlName = "http://www.wswd.net/testdownloadfiles/5MB.zip";
//    File tempFile = folder.newFile("asd.zip");
//    transferObject.startDownload(urlName, tempFile.getAbsolutePath());
//    int fileSize = (int) tempFile.length();
//    assertThat(transferObject.getTransferredBytes(), is(fileSize));
//  }

//  @Test
//  public void noUrl() {
//    DownloadAgent downloadAgent = new DownloadAgent();
//    String urlName = "";
//    String downloadedFileName = "asdf.jpg";
//    downloadAgent.startDownload(urlName, downloadedFileName);
//    assertThat(downloadAgent.getTransferredBytes(), is(0));
//  }
//
//  @Test
//  public void noFileName() {
//    DownloadAgent downloadAgent = new DownloadAgent();
//    String urlName = "http://amydrewthompson.com/wp-content/uploads/2011/02/burnout_full1.jpg";
//    String downloadedFileName = "";
//    downloadAgent.startDownload(urlName, downloadedFileName);
//    assertThat(downloadAgent.getTransferredBytes(), is(0));
//  }
//
//  @Test
//  public void invalidUrl() {
//    DownloadAgent downloadAgent = new DownloadAgent();
//    String urlName = "http://amydrewthompson.com/wp-contnt/uploads/2011/02/burnout_full1.jpg";
//    String downloadedFileName = "asdfgh.jpg";
//    downloadAgent.startDownload(urlName, downloadedFileName);
//    assertThat(downloadAgent.getTransferredBytes(), is(0));
//  }


}
