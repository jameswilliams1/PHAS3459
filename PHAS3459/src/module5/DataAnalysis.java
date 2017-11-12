package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class DataAnalysis {

  // Returns ArrayList object from web page input
  public static ArrayList<String> dataFromURL(String urlName) throws IOException {
    ArrayList<String> al = new ArrayList<String>();
    URL u = new URL(urlName);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line;
    while ((line = br.readLine()) != null) {
      al.add(line);
    }

    return al;
  }

  public static void main(String[] args) {
    String line = "";
    try {
      ArrayList<String> al = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module5/module5-xy.txt");
      System.out.println(al);
    } catch (java.io.IOException e) {
      System.out.println(e);
    }

  }

}
