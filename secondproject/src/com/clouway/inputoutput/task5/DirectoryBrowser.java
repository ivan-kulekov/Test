package com.clouway.inputoutput.task5;

import java.io.File;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class DirectoryBrowser{
  public String listContent(String path){
    File file = new File(path);
    StringBuilder stringBuilder = new StringBuilder();
    try {
      if (file.isFile()) {
        System.out.println("You enter the path to file: "+file.getAbsolutePath());
      }else{
        for (File file1 : file.listFiles()) {
          if(file1.isFile()){
            stringBuilder.append(file1.getAbsolutePath()).append(" is a file").append("\n");
          }else {
            stringBuilder.append(file1.getAbsolutePath()).append(" is a directory").append("\n");
          }
        }
      }

    }catch (NullPointerException e){
      e.printStackTrace();
      System.out.println("The name of file or directory is incorrect!");
    }
    return stringBuilder.toString();
  }

}
