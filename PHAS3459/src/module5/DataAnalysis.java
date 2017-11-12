package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class DataAnalysis {

  // Returns ArrayList object from web page input
  public static ArrayList<DataPoint> dataFromURL(String urlName) throws IOException {
    // Creates empty ArrayList
    ArrayList<DataPoint> al = new ArrayList<DataPoint>();
    URL u = new URL(urlName);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = "";
    // Iterates while next token present
    while ((line = br.readLine()) != null) {
      // Parses each line into DataPoint object
      DataPoint dp = DataPoint.parseLine(line);
      // Adds each DataPoint to ArrayList
      al.add(dp);
    }
    return al;
  }

  public static void main(String[] args) {
    try {
      // Creates ArrayList of DataPoint objects (x, y, ey) from webpage
      ArrayList<DataPoint> measurements = dataFromURL(
          "http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
      System.out.println(measurements);
    } catch (java.io.IOException e) {
      System.out.println(e);
    }

  }

}
