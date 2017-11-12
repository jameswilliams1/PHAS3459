package module5;

import java.util.Scanner;

public class DataPoint {
  /*
   * Represents results of measurements: x, y & error in y: ey & includes method
   * to parse data (as string) into DataPoint object
   */
  private final double x; // x measurement
  private final double y; // y measurement
  private final double ey; // Error in y

  public DataPoint() { // Sets all values to 0.0 when no arguments
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

  // Parses input string line (3 numbers) into DataPoint object containing x, y,
  // ey
  public static DataPoint parseLine(String line) {
    Scanner s = new Scanner(line);
    double x = 0.0;
    double y = 0.0;
    double ey = 0.0;
    // Iterates while next token present
    while (s.hasNext()) {
      // Updates each value with next token
      x = s.nextDouble();
      y = s.nextDouble();
      ey = s.nextDouble();
    }
    s.close();
    // Creates DataPoint from stored values
    return new DataPoint(x, y, ey);
  }

  // Displays DataPoint as String
  public String toString() {
    return "DataPoint [x=" + x + ", y=" + y + ", ey=" + ey + "]";
  }
}
