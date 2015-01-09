package com.clouway.networkingandgui.downloadagent;

import org.jmock.Expectations;
import org.jmock.auto.Mock;
import org.jmock.integration.junit4.JUnitRuleMockery;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DownloadAgentTest {

  @Rule
  public TemporaryFolder folder = new TemporaryFolder();
  public JUnitRuleMockery context = new JUnitRuleMockery();
  ProgressListener progressListener = context.mock(ProgressListener.class);

  @Test
  public void downloadFile() throws IOException {
    String urlName = "file:testDownloadAgent.txt";
    File tempFile = folder.newFile("asd.txt");
    DownloadAgent downloadAgent = new DownloadAgent(progressListener);
    context.checking(new Expectations() {{
      oneOf(progressListener).update(0);
      oneOf(progressListener).update(50);
      oneOf(progressListener).update(100);
    }});

    downloadAgent.startDownload(urlName, tempFile.getAbsolutePath());
  }

  @Test
  public void downloadAnotherFile() throws IOException {
    String urlName = "file:asdf.txt";
    File tempFile = folder.newFile("asdf.txt");
    DownloadAgent downloadAgent = new DownloadAgent(progressListener);
    context.checking(new Expectations() {{
      oneOf(progressListener).update(0);
      oneOf(progressListener).update(40);
      oneOf(progressListener).update(81);
      oneOf(progressListener).update(100);
    }});

    downloadAgent.startDownload(urlName, tempFile.getAbsolutePath());
  }

  @Test
  public void noUrl() {
    DownloadAgent downloadAgent = new DownloadAgent(progressListener);
    String urlName = "";
    String downloadedFileName = "asdf.jpg";
    context.checking(new Expectations(){{
      oneOf(progressListener).update(0);
    }});
    downloadAgent.startDownload(urlName, downloadedFileName);
  }

  @Test
  public void noFileName() {
    DownloadAgent downloadAgent = new DownloadAgent(progressListener);
    String urlName = "http://amydrewthompson.com/wp-content/uploads/2011/02/burnout_full1.jpg";
    String downloadedFileName = "";
    context.checking(new Expectations(){{
      oneOf(progressListener).update(0);
    }});
    downloadAgent.startDownload(urlName, downloadedFileName);
  }

  @Test
  public void invalidUrl() {
    DownloadAgent downloadAgent = new DownloadAgent(progressListener);
    String urlName = "http://amydrewthompson.com/wp-contnt/uploads/2011/02/burnout_full1.jpg";
    String downloadedFileName = "asdfgh.jpg";
    context.checking(new Expectations(){{
      oneOf(progressListener).update(0);
    }});
    downloadAgent.startDownload(urlName, downloadedFileName);
  }

}
