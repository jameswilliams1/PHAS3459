package module5;

public class Theory {
  /*
   * Represents function y=x^n where n can be set in constructor
   */
  private int n;

  // Sets n
  public Theory(int n) {
    this.n = n;
  }

  // Finds y from x & n
  public double y(double x) {
    return Math.pow(x, this.n);
  }
}
