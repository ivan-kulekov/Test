package com.clouway.inputoutput.task3;

import java.io.IOException;

/**
 * @author Dimitar Dimitrov <dimitar.dimitrov045@gmail.com>
 */
public class TextReverserDemo {
  public static void main(String[] args) throws IOException {
    TextReverser text = new TextReverser();
    text.reverse("text2.txt", "text3.txt");

  }
}
