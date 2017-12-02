package module6;

/*
 * Represents function y = ax^2 + bx + c 
 */

public class QuadraticTheory implements Theory {

  // Coefficients used in function
  private double a;
  private double b;
  private double c;

  // Constructor sets a, b, c
  public QuadraticTheory(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  // Returns ax^2 + bx + c
  @Override
  public double y(double x) {
    return (a * Math.pow(x, 2) + b * x + c);
  }

  // Displays function y = ax^2 + bx + c as string
  @Override
  public String toString() {
    return a + "x^2 + " + b + "x + " + c;
  }

}
