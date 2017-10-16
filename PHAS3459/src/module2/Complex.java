package module2;

public class Complex {
  //Defines real (a) and imaginary (b) components of complex number
  double a;
  double b;
  
  public Complex(double c, double d) {
    a = c;
    b = d;
  }
  
  public double real() {
    //returns real (a) part of complex number
    return a;
  }
  
  public double imag() {
  //returns imaginary (b) part of complex number
    return b;
  }
  
  public String toString() {
    //converts complex number to string
    String complexStringPos = Double.toString(a)+" + " + Double.toString(b) + " i";
    //String complexStringneg = Double.toString(a)+" - " + Double.toString(b) + " i";
    return complexStringPos;
    }
  
  public double modulus() {
    //Returns modulus of complex number z (|z| = (a^2 + b^2)^0.5)
    return Math.sqrt(a*a + b*b);
  }
  
  public double angle() {
    //Returns arg(z) of complex number z /radians
    return Math.atan(b / a);
  }
  
  public Complex conjugate(){
    //Returns complex conjuagte z* = a - ib of z = a + ib
    double bConj = b * -1;
    return new Complex(a, bConj);
  }
  
  public Complex normalised() {
    //Returns normalised version of z with same argument (|z| = 1)
    double aNorm = a / modulus();
    double bNorm = b / modulus();
    return new Complex(aNorm, bNorm);
  }
      
    }

  
  
  
  
   
  