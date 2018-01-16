package final2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
  private ArrayList<HashMap<Integer, Double>> data = new ArrayList<HashMap<Integer, Double>>(); // data sets from the
                                                                                                // experiment (list of
                                                                                                // HashMap<time,
                                                                                                // reading>)

  // returns name of detector
  public String getID() {
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

  // parses line of detector ID / distance from beam & creates list of Detector
  // objects
  public static ArrayList<Detector> parseID(String dir) throws IOException {
    ArrayList<Detector> dets = new ArrayList<Detector>();
    URL u = new URL(dir + "detectors.txt");
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = "";
    while ((line = br.readLine()) != null) {
      // parses each line into ID / distance
      Detector d = new Detector();
      Scanner s = new Scanner(line);
      if (s.hasNext()) {
        d.ID = s.next();
        d.distance = s.nextDouble();
        // adds to list
        dets.add(d);
      }
      s.close();

    }
    return dets;
  }

  // adds data to list of Detector objects
  public static ArrayList<Detector> addData(ArrayList<Detector> dets, String dir) throws IOException {
    URL u = new URL(dir + "signals.txt");
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = "";
    while ((line = br.readLine()) != null) {
      HashMap<String, HashMap<Integer, Double>> output = new HashMap<String, HashMap<Integer, Double>>();
      HashMap<Integer, Double> data = new HashMap<Integer, Double>();
      Scanner s = new Scanner(line);
      String name = "";
      int count = 0;
      if (s.hasNext()) {
        name = s.next();
        while (s.hasNext()) {
          data.put(count, s.nextDouble());
          count++;
        }
      }
      s.close();
      output.put(name, data);

      for (Detector det : dets) {
        if (output.containsKey(det.getID())) {
          det.data.add(output.get(det.getID()));
        }
      }
    }
    return dets;
  }

  // gets data from 2 urls in dir and combines
  public static ArrayList<Detector> dataFromURL(String dir) throws IOException {
    return addData(parseID(dir), dir);
  }

  // finds total pulses of Detector
  public int pulseCount() {
    return this.data.size();
  }

  public int signalCount() {
    int count = 0;
    for (HashMap<Integer, Double> map : this.data) {
      count += map.size();
    }
    return count;
  }

  // returns list of max amplitudes of each pulse for detector
  public ArrayList<Double> AmplitudeList() {
    ArrayList<Double> amps = new ArrayList<Double>();
    for (HashMap<Integer, Double> pulse : this.data) {
      double maxAmp = Double.MIN_VALUE;
      for (double amp : pulse.values()) {
        if (amp > maxAmp) {
          maxAmp = amp;
        }
      }
      amps.add(maxAmp);
    }
    return amps;
  }

  // returns mean amplitude of pulses for detector
  public double meanAmplitude() {
    ArrayList<Double> amps = this.AmplitudeList();
    double total = 0.0;
    for (double amp : amps) {
      total += amp;
    }
    return total / this.pulseCount();
  }

  // returns mean arrival time of pulses for detector
  public double meanT() {
    ArrayList<Double> amps = this.AmplitudeList();
    double totalT = 0;
    for (int i = 0; i < amps.size(); i++) {
      double maxAmp = amps.get(i);
      for (int key : this.data.get(i).keySet()) {
        if (this.data.get(i).get(key) == maxAmp) {
          totalT += key;
        }
      }
    }
    return totalT / this.pulseCount();
  }

}
