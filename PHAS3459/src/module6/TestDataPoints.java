package module6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

/*
 * Tests DataPoint & LabelledDataPoint classes using data from a URL
 */

public class TestDataPoints {

  // Returns list of DataPoint objects (labelled or unlabelled) from web page
  // input
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
      DataPoint dp = LabelledDataPoint.parseLine(line);
      // Adds each DataPoint to ArrayList
      al.add(dp);
    }
    return al;
  }

  public static void main(String[] args) {

    System.out.println("Reading data from http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
    System.out.println();
    try {
      ArrayList<DataPoint> al = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
      for (DataPoint data : al) { // Iterates over list printing each DataPoint/LabelledDataPoint
        System.out.println(data);
      }
    } catch (IOException e) {
      System.out.println(e + " Page does not exist");
    }

  }

}
