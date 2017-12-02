package module6;

/*
 * Represents function y = x^n
 */

public class PowerLawTheory implements Theory {

  private double n; // Power to raise x to

  // Constructor sets value of n
  public PowerLawTheory(int n) {
    this.n = n;
  }

  // Returns y = x^n
  @Override
  public double y(double x) {
    return Math.pow(x, n);
  }

  // Displays function x^n as string
  @Override
  public String toString() {
    return "x^" + n;
  }

}
