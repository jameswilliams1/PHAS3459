package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Minerals {
  /*
   * Represents a mineral (either key/mass or key/name) and defines methods to
   * input web pages as HashMap objects
   */

  // Displays Minerals object as String
  public String toString() {
    return "Minerals [key=" + key + ", mass=" + mass + ", name=" + name + "]";
  }

  private int key; // Code of sample
  private double mass; // Mass of sample
  private String name; // Location where sample found

  // Creates blank Minerals object
  public Minerals() {
    key = 0;
    mass = 0.0;
    name = "";

  }

  // Creates Minerals object from key and mass
  public Minerals(int key, double mass) {
    this.key = key;
    this.mass = mass;
  }

  // Creates Minerals object from key and name
  public Minerals(int key, String name) {
    this.name = name;
    this.key = key;
  }

  // Gets mineral key, mass or name
  public int getKey() {
    return this.key;
  }

  public double getMass() {
    return this.mass;
  }

  public String getName() {
    return this.name;
  }

  // Parses a String (line) to key and value , returns as Minerals object
  public static Minerals parseLine(String line) {
    Scanner s = new Scanner(line);
    int key = 0;
    double mass = 0.0;
    String name = "";
    Minerals m = new Minerals();
    // Iterates while scanner has next token
    while (s.hasNext()) {
      if (s.hasNextInt()) { // If key is first
        key = s.nextInt();
        mass = s.nextDouble();
        m = new Minerals(key, mass);
      } else { // If name is first
        name = s.next();
        key = s.nextInt();
        m = new Minerals(key, name);
      }
    }
    s.close();
    return m;
  }

  // Returns HashMap object (key/mass) from web page input
  public static HashMap<Integer, Double> massAsHM(String urlName) throws IOException {
    HashMap<Integer, Double> hm = new HashMap<Integer, Double>();
    URL u = new URL(urlName);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = "";
    // Iterates while next token present
    while ((line = br.readLine()) != null) {
      Minerals m = parseLine(line);
      hm.put(m.getKey(), m.mass);
    }
    return hm;
  }

  // Returns HashMap object (key/name) from web page input
  public static HashMap<Integer, String> nameAsHM(String urlName) throws IOException {
    HashMap<Integer, String> hm = new HashMap<Integer, String>();
    URL u = new URL(urlName);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = "";
    // Iterates while next token present
    while ((line = br.readLine()) != null) {
      Minerals m = parseLine(line);
      hm.put(m.getKey(), m.name);
    }
    return hm;
  }

  public static void main(String[] args) {
    // Creates HashMap objects for key/mass & key/name
    HashMap<Integer, Double> mass = new HashMap<Integer, Double>();
    HashMap<Integer, String> name = new HashMap<Integer, String>();
    try {
      mass = massAsHM("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-samples.txt");
      name = nameAsHM("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-locations.txt");
    } catch (IOException e) {
      System.out.println(e + " Page does not exist");
    }
    // Finds max / min mass
    double maxMass = Collections.max(mass.values());
    double minMass = Collections.min(mass.values());
    int maxKey = 0;
    int minKey = 0;
    // Iterates over mass HashMap to get key value associated with maxMass
    for (Entry<Integer, Double> entry : mass.entrySet()) {
      if (entry.getValue() == maxMass) {
        maxKey = entry.getKey(); // Key with max mass
      }
    }
    // Iterates over mass HashMap to get key value associated with minMass
    for (Entry<Integer, Double> entry : mass.entrySet()) {
      if (entry.getValue() == minMass) {
        minKey = entry.getKey(); // Key with min mass
      }
    }
    System.out.println("Largest mass:");
    System.out.println("Code number: " + maxKey);
    System.out.println("Mass: " + maxMass + " g");
    System.out.println("Found in: " + name.get(maxKey));
    System.out.println();
    System.out.println("Smallest mass:");
    System.out.println("Code number: " + minKey);
    System.out.println("Mass: " + minMass + " g");
    System.out.println("Found in: " + name.get(minKey));
  }

}