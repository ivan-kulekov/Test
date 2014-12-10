package com.clouway.networkingandgui.downloadagent;

import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DownloadAgentTest {

//  @Test
//  public void downloadPicture() {
//    TransferObject transferObject = new TransferObject();
//      String urlName = "http://amydrewthompson.com/wp-content/uploads/2011/02/burnout_full1.jpg";
//      String fileName = "asd.jpg";
//      transferObject.startDownload(urlName, fileName);
//    assertThat(transferObject.getTransferredBytes(), is(121403));
//  }

//  @Test
//  public void download5MbFile(){
//    TransferObject transferObject = new TransferObject();
//    String urlName = "http://www.wswd.net/testdownloadfiles/5MB.zip";
//    String downloadedFileName = "asd.zip";
//      transferObject.startDownload(urlName, downloadedFileName);
//    assertThat(transferObject.getTransferredBytes(), is(5242880));
//  }

  @Test
  public void noUrl() {
    TransferObject transferObject = new TransferObject();
    String urlName = "";
    String downloadedFileName = "asdf.jpg";
    transferObject.startDownload(urlName, downloadedFileName);
    assertThat(transferObject.getTransferredBytes(), is(0));
  }

  @Test
  public void noFileName(){
    TransferObject transferObject = new TransferObject();
    String urlName = "http://amydrewthompson.com/wp-content/uploads/2011/02/burnout_full1.jpg";
    String downloadedFileName = "";
    transferObject.startDownload(urlName, downloadedFileName);
    assertThat(transferObject.getTransferredBytes(), is(0));
  }
  
  @Test
  public void invalidUrl(){
    TransferObject transferObject = new TransferObject();
    String urlName = "http://amydrewthompson.com/wp-contnt/uploads/2011/02/burnout_full1.jpg";
    String downloadedFileName = "asdfgh.jpg";
    transferObject.startDownload(urlName, downloadedFileName);
    assertThat(transferObject.getTransferredBytes(), is(0));
  }


}
