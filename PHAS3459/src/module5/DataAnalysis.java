package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

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

  // Returns chi^2 for ArrayList of DataPoint objects using Theory object
  public static double goodnessOfFit(Theory expected, ArrayList<DataPoint> al) {
    double chi2 = 0.0;
    Iterator<DataPoint> it = al.iterator();
    // Iterates through ArrayList while next token present
    while (it.hasNext()) {
      // Creates DataPoint from each token
      DataPoint dp = it.next();
      double top = Math.pow((dp.getY() - expected.y(dp.getX())), 2); // (y_measured - y_theory)^2
      double bottom = Math.pow(dp.getEy(), 2); // ey^2
      chi2 += (top / bottom); // Adds to chi^2 sum
    }
    return chi2; // Returns sum of chi^2 values

  }

  public static void main(String[] args) {
    ArrayList<DataPoint> measurements = new ArrayList<DataPoint>();
    try {
      // Creates ArrayList of DataPoint objects (x, y, ey) from webpage
      measurements = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
      System.out.println(measurements);
    } catch (java.io.IOException e) {
      System.out.println(e + " Page does not exist");
    }
    // Creates objects representing y=x^2 / y=x^4
    Theory two = new Theory(2);
    Theory four = new Theory(4);
    System.out.println();
    System.out.println("chi^2 for n = 2:");
    System.out.println(goodnessOfFit(two, measurements));
    System.out.println();
    System.out.println("chi^2 for n = 4:");
    System.out.println(goodnessOfFit(four, measurements));
    System.out.println();
    System.out.println(
        "Both values of n give very high chi^2 values so neither is a good fit, however n=2 is technically the better fit as chi^2 is lower.");
  }

}
