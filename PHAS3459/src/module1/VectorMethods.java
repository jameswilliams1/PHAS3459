package module1;

/**
 * Defines functions related to vectors
 */
public class VectorMethods {

  public static void main(String[] args) {
    
    VectorMethods vm = new VectorMethods();
    //calls vector functions and prints results
    double dot = vm.dotProduct(1,2,3,4,5,6);
    System.out.println("The dot product of (1,2,3).(4,5,6) is: "+dot);

    double mag = vm.magnitude(1, 2, 3);
    System.out.println("The magnitude of (1,2,3) is "+mag);

    double theta = vm.angle(2, 3, 4, 1, 3, 2);
    System.out.println("The angle between vectors (2,3,4) and (1,3,2) is "+theta+" radians");

    double theta2 = vm.angle(2, 3, 4, 0, 0, 0);
    System.out.println("The code does not work for vector (0,0,0) as it has 0 magnitude so there is a divide by 0:");
    System.out.println("The angle between vectors (2,3,4) and (1,3,2) is "+theta2+" radians");
  }

  double dotProduct (double a, double b, double c, double d, double e, double f) {
    //dot product = a.d + b.e + c.f
    return a*d+b*e+c*f;
  }


  double magnitude (double a, double b, double c) {
    //magnitude = (a.a + b.b + c.c)^1/2
    return Math.sqrt(a*a+b*b+c*c);
  }


  double angle (double a, double b, double c, double d, double e, double f) {
    //finds dot product and magnitude
    double dotp = dotProduct(a,b,c,d,e,f);
    double magn = (magnitude(a, b, c))*(magnitude(d, e, f));
    //cos(theta) = dot product / magnitude
    double costheta = dotp/magn;
    return Math.acos(costheta);
  }


}