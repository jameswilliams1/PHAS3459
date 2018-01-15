package final2015;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Represents a detector in the experiment along with its recorded data
 * 
 * @author James
 *
 */
public class Detector {

  private String ID; // identifier of the detector
  private double distance; // distance in m from particle beam
  private ArrayList<HashMap<Integer, Double>> data; // data sets from the experiment (list of HashMap<time, reading>)
  
  // returns name of detector
  public String getName() {
    return this.ID;
  }

  // returns distance of detector from particle beam
  public double getDistance() {
    return this.distance;
  }

  // returns data as arraylist of hashmaps
  public ArrayList<HashMap<Integer, Double>> getData() {
    return this.data;
  }

  // Displays Detector as string
  @Override
  public String toString() {
    return "Detector [ID: " + ID + ", distance: " + distance + "m, data: " + data + "]";
  }

  // parses line of detector ID / distance from beam & creates new object
  public static Detector parseID(String line) {
    Detector d = new Detector();
    Scanner s = new Scanner(line);
    if (s.hasNext()) {
      d.ID = s.next();
      d.distance = s.nextDouble();
    }
    s.close();
    return d;
  }
  
  //parses line of ID / datapoints
  public static ArrayList<Double>

}
