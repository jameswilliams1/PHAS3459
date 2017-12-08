package module8;

/**
 * Finds the value of Pi using the MonteCarloPiCalculatorTask class with 10mil
 * points, first using 1 thread then between 4 threads
 * 
 * @author James
 *
 */

public class ThreadsTimer {

  public static void main(String[] args) {
    
    long nPoints = 10000000L;
    MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints);
    try {
      double pi = task.call();
      System.out.println(pi);
    }
    catch ( Exception e) {
      System.out.println("Error");
    }
    
    

  }

}
