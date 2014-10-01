package com.clouway.inputoutput.task5;

import java.io.IOException;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DirectoryBrowserDemo {
  public static void main(String[] args) throws IOException {
    DirectoryBrowser finder = new DirectoryBrowser();
    finder.listContent("/home/clouway/DirectoryBrowser/");
  }

}
