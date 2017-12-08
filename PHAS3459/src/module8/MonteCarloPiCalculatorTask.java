package module8;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Uses the Monte Carlo method to find Pi from a specified number of points
 * @author James
 *
 */

public class MonteCarloPiCalculatorTask implements Callable<Double> {
  
  long nPoints = 0; // Number of points to use 
  
  /**
   * Inputs number of points to use nPoints
   * @param nPoints
   */
  public MonteCarloPiCalculatorTask(long nPoints) {
    this.nPoints = nPoints;
  }

  @Override
  public Double call() throws Exception {
    Random rand = new Random();
    long n_in = 0;
    for (long iPoint = 0; iPoint < nPoints; ++iPoint) {
    double x = rand.nextDouble();
    double y = rand.nextDouble();
    double r2 = x*x + y*y;
    if (r2 < 1.0) ++n_in;
    }
    return 4.0 * n_in / nPoints;
  }

}
