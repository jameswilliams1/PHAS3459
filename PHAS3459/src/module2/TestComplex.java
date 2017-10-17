package module2;

public class TestComplex {

  public static void main(String[] args) {
    
    Complex c1 = new Complex(1, 2);
    Complex c2 = new Complex(-2, -1);
    System.out.println("c1 = " + c1);
    System.out.println("c2 = " + c2);
    System.out.println("|c1| = " + c1.modulus());
    System.out.println("arg(c1) = " + c1.angle() + " radians");
    System.out.println("arg(c2) = " + c2.angle() + " radians");
    System.out.println("c1* = " + c1.conjugate());
    System.out.println("c2* = " + c2.conjugate());
    System.out.println("c1 normalised = " + c1.normalised());
    System.out.println("c2 normalised = " + c2.normalised());
    System.out.println("c1 * c2 = " + c1.multiply(c2));
    

  }

}
