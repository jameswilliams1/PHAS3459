package module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.*;

public class DataAnalysis {
  
  public ArrayList<Double> dataFromURL(String urlName) throws IOException {
    // Returns ArrayList object from web page input
    URL u = new URL(urlName);
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    ArrayList<Double> al = new ArrayList<Double>();
    
    
    return al;
  }

  public static void main(String[] args) {
    

  }

}
