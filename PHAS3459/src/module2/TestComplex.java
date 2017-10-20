package module2;

public class TestComplex {

  public static void main(String[] args) {
    
    Complex c1 = new Complex(1, 1);
    Complex c2 = new Complex(2, 2);
    //c1.setFromModulusAngle(1, Math.PI/2);
    System.out.println(Complex.divide(c1, Complex.ZERO));


  }

}
