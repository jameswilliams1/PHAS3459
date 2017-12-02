package module6;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class DataAnalysis {

  // Selects the Theory that gives the best agreement with a given set of
  // DataPoint objects
  private static Theory bestTheory(Collection<DataPoint> data, Collection<Theory> theories,
      GoodnessOfFitCalculator gofCalculator) {
    boolean first = true;
    double bestGoodnessOfFit = 0.0;
    Theory bestTheory = null;
    for (Theory theory : theories) {
      double gof = gofCalculator.goodnessOfFit(data, theory);
      if (first) {
        bestTheory = theory;
        bestGoodnessOfFit = gof;
        first = false;
      } else if (gof < bestGoodnessOfFit) {
        bestTheory = theory;
        bestGoodnessOfFit = gof;
      }
    }
    return bestTheory;
  }

  public static void main(String[] args) {

    System.out.println("Reading data from http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
    System.out.println();
    Collection<DataPoint> datapoints = new ArrayList<DataPoint>();
    GoodnessOfFitCalculator gof = new ChiSquared(); // Empty object required for using non-static methods
    Collection<Theory> theories = new ArrayList<Theory>();
    Theory x2 = new PowerLawTheory(2);
    Theory x205 = new PowerLawTheory(2.05);
    Theory quadratic = new QuadraticTheory(1, 10, 0);
    theories.add(x2);
    theories.add(x205);
    theories.add(quadratic);

    try {
      datapoints = TestDataPoints.dataFromURL("http://www.hep.ucl.ac.uk/undergrad/3459/data/module6/module6-data.txt");
    } catch (IOException e) {
      System.out.println(e + " Page does not exist");
    }

    System.out.println("Chi^2 for data & function " + x2 + " is: " + gof.goodnessOfFit(datapoints, x2));
    System.out.println("Chi^2 for data & function " + x205 + " is: " + gof.goodnessOfFit(datapoints, x205));
    System.out.println("Chi^2 for data & function " + quadratic + " is: " + gof.goodnessOfFit(datapoints, quadratic));
    System.out.println();
    System.out.println("Best fitting function is: " + bestTheory(datapoints, theories, gof));

  }

}
