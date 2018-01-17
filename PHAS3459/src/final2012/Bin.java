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
  private double expectedCount; // expected number of readings in bin
  private double measuredCount = 0.0; // measured number of readings in bin

  public double getMinE() {
    return this.minE;
  }

  public double getMaxE() {
    return this.maxE;
  }

  public double getExpectedCount() {
    return this.expectedCount;
  }

  public double getMeasuredCount() {
    return this.measuredCount;
  }

  public void updateMeasuredCount() {
    this.measuredCount += 1.0;
  }

  public Bin(double minE, double maxE, double count) {
    this.minE = minE;
    this.maxE = maxE;
    this.expectedCount = count;
  }

  /**
   * Displays Bin as a String
   */
  @Override
  public String toString() {
    return "Bin [minE=" + minE + ", maxE=" + maxE + ", expectedCount=" + expectedCount + "]";
  }

  public boolean inRange(double lower, double upper) {
    if (this.minE >= lower && this.maxE < upper) {
      return true;
    } else {
      return false;
    }
  }

  public boolean contains(double dataPoint) {
    if (this.minE <= dataPoint && this.maxE > dataPoint) {
      return true;
    } else {
      return false;
    }
  }

}
