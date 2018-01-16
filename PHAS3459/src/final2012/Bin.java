package final2012;

import java.util.Scanner;

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

  public Bin(double minE, double maxE, double count) {
    this.minE = minE;
    this.maxE = maxE;
    this.count = count;
  }

  /**
   * Parses a String line containing bin bounds and count into a Bin object
   * 
   * @param line
   * @return
   */
  public Bin parseLine(String line) {
    Scanner s = new Scanner(line);
    double minE = 0.0;
    double maxE = 0.0;
    double count = 0.0;
    if (s.hasNext()) {
      minE = s.nextDouble();
      maxE = s.nextDouble();
      count = s.nextDouble();
    }
    s.close();
    return new Bin(minE, maxE, count);
  }
}
