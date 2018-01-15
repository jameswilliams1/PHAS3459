package final2015;

import java.io.IOException;
import java.util.ArrayList;


public class ExamPart1 {


  public static void main(String[] args) {
    
    ArrayList<Detector> dets = new ArrayList<Detector>();

    try {
      dets = Detector.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2015-16/");        
    } catch (IOException e) {
      System.out.println(e);
    }

    for(Detector det:dets) {
      System.out.println(det);
    }

  }

}
