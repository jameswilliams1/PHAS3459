package module5;

public class DataPoint {
  /*
   * Represents results of measurements: x, y & error in y: ey
   */
  private final double x; // x measurement
  private final double y; // y measurement
  private final double ey; // Error in y
  // Sets all values to 0.0 when no args

  public DataPoint() {
    this.x = 0.0;
    this.y = 0.0;
    this.ey = 0.0;
  }

  // Inputs x, y, ey
  public DataPoint(double x, double y, double ey) {
    this.x = x;
    this.y = y;
    this.ey = ey;
  }

  // Gets value of x
  public double getX() {
    return this.x;
  }

  // Gets value of y
  public double getY() {
    return this.y;
  }

  // Gets value of ey
  public double getEy() {
    return this.ey;
  }
}
