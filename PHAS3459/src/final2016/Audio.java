package final2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents an audio recording of a musical instrument with methods to
 * calculate time etc.
 * 
 * @author James
 *
 */

public class Audio {

  private String filename; // name of file
  private String instrument; // instrument used for recording
  private int f; // sampling frequency in Hz
  private int N; // total number of samples in recording
  private int maxA; // maximum possible amplitude of signal
  private ArrayList<Integer> dataPoints;

  // returns string representation of Audio object
  @Override
  public String toString() {
    return "Filename: " + filename + ", " + "Duration: " + this.getT() + " s, " + "Amplitude: " + this.getA() + " dBFS, "
        + "Instrument: " + instrument;
  }

  // create blank Audio object (strings="", numbers=0)
  public Audio() {
    this.filename = "";
    this.instrument = "";
    this.f = 0;
    this.N = 0;
    this.maxA = 0;
  }

  // returns filename
  public String getFilename() {
    return this.filename;
  }

  // returns name of instrument
  public String getInstrument() {
    return this.instrument;
  }

  // returns sampling frequency in Hz
  public int getF() {
    return this.f;
  }

  // returns number of samples
  public int getN() {
    return this.N;
  }

  // returns maximum possible amplitude of file
  public int getMaxA() {
    return this.maxA;
  }

  // gets data points of file
  public ArrayList<Integer> getData() {
    return dataPoints;
  }

  // sets sampling frequency in Hz
  public void setF(int f) {
    this.f = f;
  }

  // sets number of samples
  public void setN(int N) {
    this.N = N;
  }

  // sets maximum possible amplitude of file
  public void setMaxA(int maxA) {
    this.maxA = maxA;
  }

  // sets data points of file
  public void setData(ArrayList<Integer> dataPoints) {
    this.dataPoints = dataPoints;
  }

  // returns time of file in s (N/f)
  public double getT() {
    return this.N / this.f;
  }
  
  // returns amplitude of signal A=20log(10)/(arms/amax)
  public double getA() {
    double sum = 0.0;
    for (int datapoint: this.getData()) {
      double value = Math.pow(datapoint, 2);
      sum += value;
    }
    double rms = Math.sqrt(sum/this.N);
    double A = 20*Math.log10(rms/this.maxA);
    return A;
  }
  
  // finds spectral density of signal for given f
  public double getSpectralDensity(Audio a, double t, double f ) {
    long N = a.getN();
    double sumCos = 0.0;
    double sumSin = 0.0;
    double z = 2 * Math.PI * f * t / N;
    for ( int n = 0; n < N; n++) {
      sumCos += a.getData().get(n) + Math.cos(z * n);
      sumSin += a.getData().get(n) + Math.sin(z * n);
    }
    double norm = t / Math.pow(N, 2);
    return norm * (Math.pow(sumCos, 2) + Math.pow(sumSin, 2));
  }

  // parses line of filenames/instrument names separated by whitespace
  public static Audio parseNames(String line) {
    Audio a = new Audio();
    Scanner s = new Scanner(line);
    // iterates while tokens present
    if (s.hasNext()) {
      a.filename = s.next();
      a.instrument = s.next();
    }
    s.close();
    return a;
  }

  // parses data file of audio sample into list integers
  public static ArrayList<Integer> parseData(String urlName) throws IOException {
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    URL u = new URL(urlName);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = "";
    while ((line = br.readLine()) != null) {
      Scanner s = new Scanner(line);
      while (s.hasNext()) {
        int number = s.nextInt();
        numbers.add(number);
      }
      s.close();
    }
    return numbers;
  }

}
