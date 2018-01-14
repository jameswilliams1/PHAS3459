package final2016;

/**
 * Method to determine whether audio sample is long (>1s) or short (<1s)
 * 
 * @author James
 *
 */

public class FindLength implements Classify {

  // determines if length is long or short
  @Override
  public String classify(Audio a) {
    if( a.getT() > 1.0) {
      return "Long";
    }
    else {
      return "Short";
    }
  }

}
