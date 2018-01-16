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

}
