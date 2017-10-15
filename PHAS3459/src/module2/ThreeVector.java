package module2;

public class ThreeVector {
  
  double x;
  double y;
  double z;
  
  
  
  public ThreeVector(double a, double b, double c) {
    this.x = a;
    this.y = b;
    this.z = c;
  }
  
  public double magnitude() {
    return Math.sqrt(x*x+y*y+z*z); //magnitude = (a.a + b.b + c.c)^0.5
  }
  


  public ThreeVector unitVector() {
    
    double i = x/magnitude();
    double j = y/magnitude();
    double k = z/magnitude();
    return new ThreeVector(i,j,k);
    
  }
  
}


















  
  
  
  
  
  
  
  
 
  
  


