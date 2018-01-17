package module8;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * Uses the Monte Carlo method to find Pi from a user specified number of points
 * 
 * @author James
 *
 */

public class MonteCarloPiCalculatorTask implements Callable<Double> {

  long nPoints = 0; // Number of points to use

  /**
   * Inputs number of points to use nPoints
   * 
   * @param nPoints
   */
  public MonteCarloPiCalculatorTask(long nPoints) {
    this.nPoints = nPoints;
  }

  /**
   * Calls Monte Carlo method to find Pi using nPoints
   * 
   * @return Pi
   */
  @Override
  public Double call() {
    Random rand = new Random();
    long n_in = 0; // Number of points found in unit circle
    for (long iPoint = 0; iPoint < nPoints; ++iPoint) { // Finds nPoints number of coords. in unit square
      double x = rand.nextDouble();
      double y = rand.nextDouble();
      double r2 = x * x + y * y; // Distance^2 from origin to point
      if (r2 < 1.0)
        ++n_in; // Adds to total if point in unit circle
    }
    return 4.0 * n_in / nPoints; // Pi/4 = points in unit circle/points in unit square
  }

}
