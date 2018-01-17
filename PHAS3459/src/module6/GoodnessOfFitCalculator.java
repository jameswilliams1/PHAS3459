package module6;

import java.util.Collection;

/*
 * Represents a method of finding the goodness of fit of data and theory
 */

public interface GoodnessOfFitCalculator {

  // Finds goodness of fit between data points and theory
  double goodnessOfFit(Collection<DataPoint> data, Theory theory);
}
