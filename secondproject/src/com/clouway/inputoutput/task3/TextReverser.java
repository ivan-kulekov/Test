package com.clouway.inputoutput.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TextReverser {
  public void reverse(String inputFile, String outputFile) throws IOException {
    FileWriter fileWriter = null;
    BufferedReader fileReader = null;

    try {
      fileWriter = new FileWriter(outputFile);
      fileReader = new BufferedReader(new FileReader(inputFile));
      StringBuilder str = new StringBuilder();
      String c;

      while ((c = fileReader.readLine()) != null) {
        str.append("\n");
        str.append(c);
        str.reverse();
        c = str.toString();
        str.setLength(0);
        System.out.println(c);
        fileWriter.write(c);


      }

    } finally {
      if (fileReader != null) {
        fileReader.close();
      }
      if (fileWriter != null) {
        fileWriter.close();
      }

    }
  }
}
