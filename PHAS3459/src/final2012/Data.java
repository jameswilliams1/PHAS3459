package final2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import final2016.Audio;

public class Data {

  /**
   * Parses a (String) line containing bin bounds and count, returns a Bin object
   * 
   * @param line
   * @return
   */
  public static Bin parseLine(String line) {
    Scanner s = new Scanner(line);
    double minE = 0.0;
    double maxE = 0.0;
    double count = 0.0;
    if (s.hasNext()) {
      minE = s.nextDouble();
      maxE = s.nextDouble();
      count = s.nextDouble();
    }
    s.close();
    return new Bin(minE, maxE, count);
  }
  
  public static ArrayList<Bin> dataFromURL(String url) throws IOException {
    ArrayList<Bin> data = new ArrayList<Bin>();
    URL u = new URL(url);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = "";
    br.readLine(); //skips headers (1 line)
    while ((line = br.readLine()) != null) {
      Bin b = parseLine(line);
      data.add(b);
    }
    return data;
  }

  public static void main(String[] args) {
    
    ArrayList<Bin> backgroundGG = new ArrayList<Bin>();
    ArrayList<Bin> backgroundZZ = new ArrayList<Bin>();
    try {
      backgroundGG = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2012-13/backgroundGG.txt");
      backgroundZZ = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2012-13/backgroundZZ.txt");
    } catch (IOException e) {
      System.out.println(e);
    }
    
    System.out.println(backgroundGG);
    System.out.println(backgroundZZ);
    

  }

}
