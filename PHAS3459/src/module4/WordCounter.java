package module4;

import java.io.*;
import java.nio.*;
import java.net.*;



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
  


  
  
  
  
  
  
  
  public static void main(String[] args) {
    String line;
    try {
      BufferedReader webBuffer = brFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module4/module4_text.txt");
      while((line = webBuffer.readLine()) != null) {
        System.out.println(line);
      }
    }
    catch (java.io.IOException e) {
      
    }
    
    
  }

}
