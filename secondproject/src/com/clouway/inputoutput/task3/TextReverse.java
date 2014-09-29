package com.clouway.inputoutput.task3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by mitko on 14-9-27.
 */
public class TextReverse {
    public void reverseText() throws IOException {
        FileWriter fileWriter = null;
        FileReader fileReader = null;
        try{
            fileWriter = new FileWriter("text3.txt");
            fileReader = new FileReader("text2.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            StringBuilder str = new StringBuilder();
            String c;

            while((c = bufferedReader.readLine()) != null ){
                str.append(c);
                str.reverse();
                str.append("\n");
                c = str.toString();
                System.out.println(c);
                fileWriter.write(c);
            }

        }finally {
            if( fileReader != null){
                fileReader.close();
            }
            if(fileWriter != null){
                fileWriter.close();
            }

        }
    }
}
