package module4;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class NumericalReader {
  /*
   * Defines functions for reading and processing numerical files
   * 
   */

  public static String getStringFromKeyboard() throws IOException {
    // Prompts user to enter string & returns keyboard input through BufferedReader
    System.out.println("Please enter a string:");
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    String s = br.readLine();
    return s;
  }

  public BufferedReader brFromURL(String urlName) throws IOException {
    // Returns BufferedReader object from web page input using java.net.URL
    URL u = new URL(urlName);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    return new BufferedReader(isr);
  }

  public static void main(String[] args) {

    NumericalReader numReader = new NumericalReader();
    String line;

    try {
      String webPage = getStringFromKeyboard();
      System.out.println(webPage);
     
      BufferedReader webBuffer = numReader.brFromURL(webPage);
      // Prints each line until readLine returns a null (empty) line
      while ((line = webBuffer.readLine()) != null) {
        System.out.println(line);
    }
    }
    catch (java.io.IOException e) {
      System.out.println(e);
    }

  

}
}
