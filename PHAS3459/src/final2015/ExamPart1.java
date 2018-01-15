package final2015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ExamPart1 {

  // reads each line from detectors list
  public static ArrayList<Detector> dataFromURL(String dir) throws IOException {
    ArrayList<Detector> dets = new ArrayList<Detector>();
    URL u = new URL(dir + "detectors.txt");
    InputStream is = u.openStream();
    InputStreamReader isr = new InputStreamReader(is);
    BufferedReader br = new BufferedReader(isr);
    String line = "";
    while ((line = br.readLine()) != null) {
      // parses each line into ID / distance
      Detector d = Detector.parseID(line);
      // adds to list
      dets.add(d);
    }
    return dets;
  }

  public static void main(String[] args) {
    
    ArrayList<Detector> dets = new ArrayList<Detector>();

    try {
      dets = dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/");
      
    } catch (IOException e) {
      System.out.println(e);
    }

    for(Detector det:dets) {
      System.out.println(det);
    }

  }

}
