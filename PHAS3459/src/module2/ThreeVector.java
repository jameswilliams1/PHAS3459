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
  
  public static double magnitude(ThreeVector v) {
  //Magnitude = (a.a + b.b + c.c)^0.5 for vector (a, b, c)
    return Math.sqrt(v.x*v.x+v.y*v.y+v.z*v.z);
  }
  
  public static ThreeVector unitVector(ThreeVector v) {
    //Unit vector = (x, y, z) / magnitude
    double i = v.x / magnitude(v);
    double j = v.y / magnitude(v);
    double k = v.z / magnitude(v);
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
  
  public static ThreeVector vectorProduct(ThreeVector v, ThreeVector w) {
    //(a, b, c)X(d. e. f) = ((b.f-c.e), (c.d-a.f), (a.e-b.d))
    double i = v.y*w.z - v.z*w.y;
    double j = v.z*w.x - v.x*w.z;
    double k = v.x*w.y - v.y*w.x;
    return new ThreeVector(i, j, k);
  }
  
  public static ThreeVector add(ThreeVector v, ThreeVector w) {
    //Sums 2 ThreeVector objects
    return new ThreeVector(v.x+w.x, v.y+w.y, v.x+w.z);
  }
    
  public static double angle(ThreeVector v, ThreeVector w) {
    //Angle (radians) between vectors u and v = theta = Arccos((u.v)/(|u|.|v|))
    return Math.acos(scalarProduct(v, w)/(magnitude(v)*magnitude(w)));
  }
  


}


















  
  
  
  
  
  
  
  
 
  
  


