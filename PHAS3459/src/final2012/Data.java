package final2012;

/**
 * Tools for analysing data using Bin objects
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

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

  /**
   * Gets expected data from a url, returns list of Bin objects
   * 
   * @param url
   * @return
   * @throws IOException
   */
  public static ArrayList<Bin> theoryFromURL(String url) throws IOException {
    ArrayList<Bin> data = new ArrayList<Bin>();
    URL u = new URL(url);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = "";
    br.readLine(); // skips headers (1 line)
    while ((line = br.readLine()) != null) {
      Bin b = parseLine(line);
      data.add(b);
    }
    return data;
  }

  /**
   * Counts the number of expected events in a specified energy range (min-max)
   * for list of Bin (bins)
   * 
   * @param bins
   * @param min
   * @param max
   * @return count
   */
  public static double countExpectedEvents(ArrayList<Bin> bins, double min, double max) {
    double count = 0.0;
    for (Bin bin : bins) {
      if (bin.inRange(min, max)) {
        count += bin.getExpectedCount();
      }
    }
    return count;
  }

  /**
   * Counts the number of measured events in a specified energy range (min-max)
   * for list of Bin (bins)
   * 
   * @param bins
   * @param min
   * @param max
   * @return count
   */
  public static double countMeasuredEvents(ArrayList<Bin> bins, double min, double max) {
    double count = 0.0;
    for (Bin bin : bins) {
      if (bin.inRange(min, max)) {
        count += bin.getMeasuredCount();
      }
    }
    return count;
  }

  /**
   * Returns list of event energies for a given channel (String)
   * 
   * @param ID
   * @param url
   * @return
   * @throws IOException
   */
  public static ArrayList<Double> dataFromURL(String ID, String url) throws IOException {
    URL u = new URL(url);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = "";
    ArrayList<Double> data = new ArrayList<Double>();
    br.readLine(); // skips headers (1 line)
    double thisValue = 0.0;
    String thisID = "";
    while ((line = br.readLine()) != null) { // iterates over each line
      Scanner s = new Scanner(line);
      if (s.hasNext()) {
        thisID = s.next(); // updates thisID to next token
        if (thisID.equals(ID)) { // checks if thisID is the same as required ID (input)
          thisValue = s.nextDouble();
          data.add(thisValue); // adds value to list if ID matches
        }
      }
      s.close();
    }
    return data;
  }

  /**
   * Updates corresponding bin (measured) count +1 for each data point
   * 
   * @param data
   * @param bins
   */
  public static void sortData(ArrayList<Double> data, ArrayList<Bin> bins) {
    for (double point : data) { // iterates over all data points
      for (Bin bin : bins) { // iterates over all bins
        if (bin.contains(point)) { // checks if point is in the bounds of the bin
          bin.updateMeasuredCount();
        }
      }
    }
  }

  /**
   * Finds log likelihood of a list of Bins (compares measured to actual counts)
   * 
   * @param bins
   * @return LL (log likelihood)
   */
  public static double logLike(ArrayList<Bin> bins) {
    double LL = 0.0;
    double log = 0.0;
    double bracket = 0.0;
    double sum = 0.0;
    for (Bin bin : bins) { // iterates over each bin
      bracket = bin.getExpectedCount() - bin.getMeasuredCount(); // (yi - ni)
      log = bin.getMeasuredCount() * Math.log(bin.getMeasuredCount() / bin.getExpectedCount()); // ni * ln(ni / yi)
      sum = bracket + log;
      LL += (sum); // adds LL value for each bin to total
    }
    return LL;
  }

  public static void main(String[] args) {

    ArrayList<Bin> backgroundGG = new ArrayList<Bin>(); // initialises all lists (empty)
    ArrayList<Bin> backgroundZZ = new ArrayList<Bin>();
    ArrayList<Double> dataGG = new ArrayList<Double>();
    ArrayList<Double> dataZZ = new ArrayList<Double>();

    try {
      backgroundGG = theoryFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2012-13/backgroundGG.txt");
      backgroundZZ = theoryFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2012-13/backgroundZZ.txt");
      dataGG = dataFromURL("GG", "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2012-13/higgsData.txt");
      dataZZ = dataFromURL("ZZ", "http://www.hep.ucl.ac.uk/undergrad/3459/exam-data/2012-13/higgsData.txt");
    } catch (IOException e) {
      System.out.println(e);
    }

    sortData(dataGG, backgroundGG);
    sortData(dataZZ, backgroundZZ);

    System.out.println("For GG channel:");
    System.out
        .println("Expected background events in range 120-240GeV (GG): " + countExpectedEvents(backgroundGG, 120, 240));
    System.out
        .println("Number of candidate events in range 120-240GeV: " + countMeasuredEvents(backgroundGG, 120, 240));
    System.out.println("Log likelihood : " + logLike(backgroundGG));
    System.out.println();

    System.out.println("For ZZ channel:");
    System.out
        .println("Expected background events in range 120-240GeV (ZZ): " + countExpectedEvents(backgroundZZ, 120, 240));
    System.out
        .println("Number of candidate events in range 120-240GeV: " + countMeasuredEvents(backgroundZZ, 120, 240));
    System.out.println("Log likelihood : " + logLike(backgroundZZ));
  }

}
