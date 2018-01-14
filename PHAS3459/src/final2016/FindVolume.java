package final2016;

/**
 * Method to determine whether an audio sample is loud (-20dBFS<) or quiet
 * (<-20dBFS)
 * 
 * @author James
 *
 */

public class FindVolume implements Classify {

  @Override
  public String classify(Audio a) {
    if(a.getA() > -20.0) {
      return "Loud";
    }
    else {
      return "Quiet";
          }
  }

}
