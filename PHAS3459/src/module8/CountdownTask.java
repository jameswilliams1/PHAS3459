package module8;

/**
 * Counts down from user input integer (in s) printing remaining time each
 * second
 * 
 * @author James
 *
 */

public class CountdownTask implements Runnable {

  private int countdown; // Time to count down from (in s)

  /**
   * Inputs count down time
   * 
   * @param time
   */
  public CountdownTask(int countdown) {
    this.countdown = countdown;
  }

  /**
   * Prints time remaining each second and stops at 0
   */
  @Override
  public void run() {
    System.out.println("Time remaining: ");
    for (int t = countdown; t > 0; t--) {
      System.out.println(t + "s");
      try {
        Thread.sleep(1000); // Waits 1s
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return;
  }

}
