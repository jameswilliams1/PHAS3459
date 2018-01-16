package final2012;

/**
 * Represents an energy bin between 2 values for an ATLAS experiment
 * 
 * @author James
 *
 */
public class Bin {

  private double minE; // bin lower bound
  private double maxE; // bin upper bound
  private double count; // number of readings in bin

  public double getMinE() {
    return this.minE;
  }

  public double getMaxE() {
    return this.maxE;
  }

  public double getCount() {
    return this.count;
  }

  public Bin(double minE, double maxE, double count) {
    this.minE = minE;
    this.maxE = maxE;
    this.count = count;
  }

  /**
   * Displays Bin as a String
   */
  @Override
  public String toString() {
    return "Bin [minE=" + minE + ", maxE=" + maxE + ", count=" + count + "]";
  }

  public boolean inRange(double lower, double upper) {
    if (this.minE >= lower && this.maxE < upper) {
      return true;
    } else {
      return false;
    }
  }

}
