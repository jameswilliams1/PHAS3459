package module4;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

public class NumericalReader {
  /* Defines functions for reading and processing numerical files
   * 
   */
  
  public static String getStringFromKeyboard() throws IOException {
    System.out.println("Please enter a string:");
    InputStreamReader is = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader(is);
    String s = br.readLine();
    //System.out.println(s);
    return s;
    
  }
  
  

  public static void main(String[] args) {

    NumericalReader numReader = new NumericalReader();
    
    try {
      String webpage = getStringFromKeyboard();
      System.out.println(webpage);
    }
    catch (java.io.IOException e) {
      System.out.println(e);
    }

  }

}
