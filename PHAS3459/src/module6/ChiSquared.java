package module6;

import java.util.Collection;
import java.util.Iterator;

/*
 * Performs the chi^2 test using data and a theory
 */

public class ChiSquared implements GoodnessOfFitCalculator {

  // Returns chi^2 for ArrayList of DataPoint objects using Theory object
  @Override
  public double goodnessOfFit(Collection<DataPoint> al, Theory expected) {
    double chi2 = 0.0;
    Iterator<DataPoint> it = al.iterator();
    // Iterates through ArrayList while next token present
    while (it.hasNext()) {
      // Creates DataPoint from each token
      DataPoint dp = it.next();
      double top = Math.pow((dp.getY() - expected.y(dp.getX())), 2); // (y_measured - y_theory)^2
      double bottom = Math.pow(dp.getEy(), 2); // ey^2
      chi2 += (top / bottom); // Adds to chi^2 sum
    }
    return chi2; // Returns sum of residuals/error

  }

}
