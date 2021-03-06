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

    int totalPulse = 0; // initialises total pulse/amplitude count
    double totalAmp = 0.0;
    double c = 3 * (Math.pow(10, 8)); // speed of light m/s

    for (Detector det : dets) { // iterates over each Detector updating totals
      totalPulse += det.pulseCount();
      totalAmp += det.meanAmplitude();
    }

    double meanAmp = totalAmp / dets.size();
    System.out.println("Total pulse count: " + totalPulse);
    System.out.println("Mean amplitude of pulses: " + meanAmp + " V");
    System.out.println("");

    for (Detector det : dets) {
      System.out.println("Detector " + det.getID() + ":");
      System.out.println("Number of signals " + ": " + det.signalCount());
      System.out.println("Mean amplitude of pulses for this detector: " + det.meanAmplitude() + " V");
      System.out.println("Mean arrival time of particles for this detector: " + det.meanT() + " ns");
      System.out.println(
          "Average speed of particles for this detector: " + det.MeanSpeed() + " m/s / " + det.MeanSpeed() / c + " c");
      System.out.println();
    }

  }

}
