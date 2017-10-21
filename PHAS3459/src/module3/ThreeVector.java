package module3;

public class ThreeVector {
  // Represents x, y, z components of 3D vector
  private double x;
  private double y;
  private double z;

  public ThreeVector() {
    x = 0.0;
    y = 0.0;
    z = 0.0;
  }

  public ThreeVector(double x, double y, double z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }

  public void setX(double x) {
    // Sets x component of vector
    this.x = x;
  }

  public void setY(double y) {
    // Sets y component of vector
    this.y = y;
  }

  public void setZ(double z) {
    // Sets z component of vector
    this.z = z;
  }

  public double getX() {
    // Returns x component of vector
    return this.x;
  }

  public double getY() {
    // Returns y component of vector
    return this.y;
  }

  public double getZ() {
    // Returns z component of vector
    return this.z;
  }

  public double magnitude() {
    // Magnitude = (a.a + b.b + c.c)^0.5 for vector (a, b, c)
    return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2) + Math.pow(this.z, 2));
  }

  public ThreeVector unitVector() {
    // Unit vector = (x, y, z) / magnitude
    double i = this.x / this.magnitude();
    double j = this.y / this.magnitude();
    double k = this.z / this.magnitude();
    return new ThreeVector(i, j, k);
  }

  public String toString() {
    return "(" + Double.toString(this.x) + ", " + Double.toString(this.y) + ", " + Double.toString(this.z) + ')';
  }

  public static double scalarProduct(ThreeVector v1, ThreeVector v2) {
    // (a, b, c).(d, e, f) = a.d + b.e + c.f
    return (v1.x * v2.x + v1.y * v2.y + v1.z * v2.z);
  }

  public static ThreeVector vectorProduct(ThreeVector v1, ThreeVector v2) {
    // (a, b, c)X(d. e. f) = ((b.f-c.e), (c.d-a.f), (a.e-b.d))
    double i = v1.y * v2.z - v1.z * v2.y;
    double j = v1.z * v2.x - v1.x * v2.z;
    double k = v1.x * v2.y - v1.y * v2.x;
    return new ThreeVector(i, j, k);
  }

  public static ThreeVector add(ThreeVector v1, ThreeVector v2) {
    // Sums 2 ThreeVector objects
    return new ThreeVector(v1.x + v2.x, v1.y + v2.y, v1.x + v2.z);
  }

  public static double angle(ThreeVector v1, ThreeVector v2) {
    // Angle (radians) between vectors v1 and v2 = theta =
    // Arccos((v1.v2)/(|v1|.|v2|))
    return Math.acos(scalarProduct(v1, v2) / (v1.magnitude() * v2.magnitude()));
  }

  public double scalarProduct(ThreeVector v) {
    // Non-static version of scalarProduct
    return scalarProduct(this, v);
  }

  public ThreeVector vectorProduct(ThreeVector v) {
    // Non-static version of vectorProduct
    return vectorProduct(this, v);
  }

  public ThreeVector add(ThreeVector v) {
    // Non-static version of add
    return add(this, v);
  }

  public double angle(ThreeVector v) {
    // Non-static version of angle
    return angle(this, v);
  }

}
