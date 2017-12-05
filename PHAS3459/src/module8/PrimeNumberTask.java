package module8;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Checks if integers are prime and adds to a list if they are. Continues until
 * interrupted.
 * 
 * @author James
 *
 */

public class PrimeNumberTask implements Runnable {

  private static Collection<Integer> primeList = new ArrayList<Integer>();
  private static int largestN = 0;

  /**
   * Returns list of primes
   * 
   * @return primeList
   */
  public static Collection<Integer> getList() {
    return primeList;
  }

  /**
   * Gets the largest integer checked
   * 
   * @return largestN
   */
  public static int getN() {
    return largestN;
  }

  /**
   * Checks if an integer n is prime by dividing by each integer from 2 to sqrt(n)
   * 
   * @param n
   * @return
   */
  private static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int i = 2; i <= Math.sqrt(n); i++) {
      if (n % i == 0) { // modulo = 0 --> not prime
        return false;
      }
    }
    return true; // Only returns true if all modulo were not 0
  }

  /**
   * Checks if each integer (2+) is prime and adds primes to list.
   */
  @Override
  public void run() {
    primeList.clear(); // Clears list each run
    for (int n = 2; n < Integer.MAX_VALUE; n++) { // Iterates over all integers
      largestN = n;
      if (Thread.currentThread().isInterrupted()) { // Checks if thread has been interrupted
        return;
      }
      if (isPrime(n) == true) { // Adds to list if prime
        primeList.add(n);
      }
    }
  }

}
