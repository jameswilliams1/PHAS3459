package module4;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class WordCounter {
  /*
   * Defines functions for reading text from a web page or local file, and for
   * counting the words.
   */

  public static BufferedReader brFromURL(String urlName) throws IOException {
    // Returns BufferedReader object from web page input using java.net.URL
    URL u = new URL(urlName);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    return new BufferedReader(isr);
  }

  public static BufferedReader brFromFile(String fileName) throws IOException {
    // Returns BufferedReader object from local text file input
    return new BufferedReader(new FileReader(fileName));
  }

  public static int countWordsInResource(BufferedReader dataAsBR) throws IOException {
    int wordCount = 0;
    Scanner s = new Scanner(dataAsBR);
    // Adds to word count while there is another token then moves to next token
    while (s.hasNext()) {
      wordCount += 1;
      s.next();
    }
    // Closes scanner
    s.close();
    return wordCount;
  }

  public static void main(String[] args) {
    
    String line;
    try {
      // Creates BufferedReader object from a web page
      BufferedReader webBuffer = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
      // Prints each line until readLine returns a null (empty) line
      while ((line = webBuffer.readLine()) != null) {
        System.out.println(line);
      }
    } 
    catch (java.io.IOException e) {
      System.out.println(e);
    }
    try {
      // Creates BufferedReader object and calls word count function
      BufferedReader webBuffer = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
      System.out.println("Word count is: " + countWordsInResource(webBuffer));
    } 
    catch (java.io.IOException e) {
      System.out.println(e);
    }

  }

}
