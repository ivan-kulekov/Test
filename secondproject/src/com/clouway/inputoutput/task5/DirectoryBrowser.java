package com.clouway.inputoutput.task5;

import java.io.File;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DirectoryBrowser{
  public void listContent(String path){
    File file = new File(path);
    try {
      if (file.isFile()) {
        System.out.println("You enter the path to file.");
      }
      for (File file1 : file.listFiles()) {
        if (file1.isFile()) {
          System.out.println(file1.getAbsolutePath() + " is a file");
        } else {
          System.out.println(file1.getAbsolutePath() + " is a directory");
          path = file1.getAbsolutePath();
          listContent(path);
        }
      }
    }catch (NullPointerException e){
      e.printStackTrace();
      System.out.println("The name of file or directory is incorrect!");;
    }

  }

}
