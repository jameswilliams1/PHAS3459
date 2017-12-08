package module8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Finds the value of Pi using the MonteCarloPiCalculatorTask class with 10mil
 * points, first using 1 thread then between 4 threads
 * 
 * @author James
 *
 */

public class ThreadsTimer {

  public static void main(String[] args) {

    long nPoints = 10000000L; // Total number of points to generate

    // Using 1 thread
    MonteCarloPiCalculatorTask task = new MonteCarloPiCalculatorTask(nPoints);
    long startT1 = System.currentTimeMillis(); // Start time in ms
    double pi = task.call();
    long t1 = System.currentTimeMillis() - startT1; // Time taken
    System.out.println("Using 1 thread Pi = " + pi);
    System.out.println("Time taken was: " + (double) t1 / 1000 + "s");
    System.out.println();

    // Using 4 threads
    int nThreads = 4;
    ExecutorService threadPool = Executors.newFixedThreadPool(nThreads);
    List<Future<Double>> futures = new ArrayList<Future<Double>>();
    long startT2 = System.currentTimeMillis(); // Start time in ms
    for (int iThread = 0; iThread < nThreads; ++iThread) {
      MonteCarloPiCalculatorTask task2 = new MonteCarloPiCalculatorTask(nPoints / nThreads); // Divides nPoints between
                                                                                             // each thread
      Future<Double> future = threadPool.submit(task2);
      futures.add(future);
    }
    double sum = 0.0;
    for (int iThread = 0; iThread < nThreads; ++iThread) { // Calculates on each thread
      double result = 0.0;
      try {
        result = futures.get(iThread).get();
      } catch (InterruptedException e) {
        System.out.println(e);
        e.printStackTrace();
      } catch (ExecutionException e) {
        System.out.println(e);
        e.printStackTrace();
      }
      sum += result;
    }
    threadPool.shutdown();
    double piNew = sum / nThreads; // Averages sum of values from each thread
    long t2 = System.currentTimeMillis() - startT2; // Time taken
    System.out.println("Using 4 threads Pi = " + piNew);
    System.out.println("Time taken was: " + (double) t2 / 1000 + "s");

    System.out.println();
    System.out.println(
        "Using more threads to find Pi is faster, but 4 times as many threads doesn't lead to a result four times as fast so there is not a direct relation. Time taken was around three times faster on test computer.");
  }

}
