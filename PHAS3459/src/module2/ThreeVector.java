package module2;

public class ThreeVector {
  //Represents x, y, z components of 3D vector
  double x;
  double y;
  double z;
  
  public ThreeVector(double a, double b, double c) {
    x = a;
    y = b;
    z = c;
  }
  
  public double magnitude() {
  //Magnitude = (a.a + b.b + c.c)^0.5 for vector (a, b, c)
    return Math.sqrt(x*x+y*y+z*z);
  }
  
  public ThreeVector unitVector() {
    //Unit vector = (x, y, z) / magnitude
    double i = x / magnitude();
    double j = y / magnitude();
    double k = z / magnitude();
    return new ThreeVector(i, j, k); 
  }
  
  public String toString() {
    String vectorString = "("+ Double.toString(x) + ", "+Double.toString(y) + ", "+Double.toString(z) + ')';
    return vectorString;
  }
  
  public static double scalarProduct(ThreeVector v, ThreeVector w) {
    //(a, b, c).(d, e, f) = a.d + b.e + c.f
    return (v.x*w.x + v.y*w.y + v.z*w.z);
  }
  
  public ThreeVector vectorProduct(ThreeVector v) {
    //(a, b, c)X(d. e. f) = ((b.f-c.e), (c.d-a.f), (a.e-b.d))
    double i = this.y*v.z - this.z*v.y;
    double j = this.z*v.x - this.x*v.z;
    double k = this.x*v.y - this.y*v.x;
    return new ThreeVector(i, j, k);
  }
  
  public ThreeVector add(ThreeVector v) {
    //Sums 2 ThreeVector objects
    return new ThreeVector(this.x+v.x, this.y+v.y, this.x+v.z);
  }
    
  public double angle(ThreeVector v) {
    //Angle (radians) between vectors u and v = theta = Arccos((u.v)/(|u|.|v|))
    return Math.acos(this.scalarProduct(v)/(this.magnitude()*v.magnitude()));
  }
  


}


















  
  
  
  
  
  
  
  
 
  
  


