package final2016;

import java.io.IOException;
import java.util.ArrayList;

public class ExamPart3 {

  public static void main(String[] args) {
    ArrayList<Audio> sounds = new ArrayList<Audio>();
    Classify specDen = new SpectralDensity();

    try {
      sounds = ExamPart1.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/exam_data/2016-17/");

    } catch (IOException e) {
      System.out.println(e);
    }

    for (Audio sound : sounds) {
      System.out.println(sound);
      System.out.println("Spectral Density: " + specDen.classify(sound));
      System.out.println();
    }
  }

}
