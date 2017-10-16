package module2;

public class ThreeVector {
  //Defines x, y, z components of 3D vector
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
    ///Unit vector = (x, y, z) / magnitude
    double i = x / magnitude();
    double j = y / magnitude();
    double k = z / magnitude();
    return new ThreeVector(i, j, k); 
  }
  
  public String toString() {
    String vectorString = "("+ Double.toString(x) + ", "+Double.toString(y) + ", "+Double.toString(z) + ')';
    return vectorString;
  }
  


}


















  
  
  
  
  
  
  
  
 
  
  


