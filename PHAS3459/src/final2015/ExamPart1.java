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
      //System.out.println(det);
    }
    int totalPulse = 0;
    double totalAmp = 0.0;
    for( Detector det:dets) {
      totalPulse += det.pulseCount();
      totalAmp += det.meanAmplitude();
    }
    double meanAmp = totalAmp / dets.size();
    //System.out.println("Total pulse count: " + totalPulse);
    //System.out.println("Mean amplitude of pulses: " + meanAmp);
    
    for(Detector det:dets) {
      //System.out.println("Detector " + det.getID() + ":");
      //System.out.println("Number of signals " + ": " + det.signalCount());
      //System.out.println("Mean amplitude of pulses (this detector); " + det.meanAmplitude());
      //System.out.println("");
    }
    System.out.println("amplitude: " + dets.get(0).AmplitudeList());
    System.out.println("");
  }

}
