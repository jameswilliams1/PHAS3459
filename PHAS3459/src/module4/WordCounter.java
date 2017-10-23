package module4;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class WordCounter {
  
  public static BufferedReader brFromURL(String urlName) throws IOException {
    URL u = new URL(urlName);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    return new BufferedReader(isr);
  }
  
  public static BufferedReader brFromFile(String fileName) throws IOException{
    return new BufferedReader(new FileReader(fileName));
  }
  
  public static int countWordsInResource(BufferedReader dataAsBR) throws IOException {
    int wordCount = 0;
    Scanner s = new Scanner(dataAsBR);
    while(s.hasNext()) {
      wordCount += 1;
      s.next();
      
    }
    s.close();
    return wordCount;
  }
  
  public static void main(String[] args) {
    String line;
    try {
      BufferedReader webBuffer = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
      while((line = webBuffer.readLine()) != null) {
        System.out.println(line);
      } 
    }
    catch (java.io.IOException e) {
      System.out.println(e);
    }
    try {
      BufferedReader webBuffer = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
      System.out.println("Word count is: " + countWordsInResource(webBuffer));
    }
    catch (java.io.IOException e) {
      System.out.println(e);
    }
    

    
    

  }

}
