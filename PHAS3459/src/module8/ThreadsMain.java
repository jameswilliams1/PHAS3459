package module8;

import java.util.Collections;

/**
 * Tests CountdownTask and PrimeNumberTask by running each in a separate thread
 * and interrupting PrimeNumbertask when the count down finishes. Prints largest
 * integer checked, largest prime number and total number of prime numbers
 * found.
 * 
 * @author James
 *
 */

public class ThreadsMain {

  public static void main(String[] args) {
    Thread timer = new Thread(new CountdownTask(10)); // Creates 10s countdown thread
    Thread primes = new Thread(new PrimeNumberTask()); // Creates thread for generating primes
    timer.start();
    primes.start();

    try {
      timer.join(); // Waits for timer to finish
      primes.interrupt();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    System.out.println("Largest integer checked was: " + PrimeNumberTask.getN());
    System.out.println("Largest prime number found was: " + Collections.max(PrimeNumberTask.getList()));
    System.out.println("Number of prime numbers found was: " + PrimeNumberTask.getList().size());
  }

}
