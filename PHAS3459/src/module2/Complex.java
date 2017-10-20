package module2;

public class Complex {
  //Represents real (a) and imaginary (b) components of complex number
  private double a;
  private double b;
  
  public Complex(double real, double imag) {
    a = real;
    b = imag;
  }
  
  public double real() {
    //returns real (a) part of complex number
    return a;
  }
  
  public double imag() {
  //returns imaginary (b) part of complex number
    return b;
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
    return new Complex(this.a, -this.b);
  }
  
  public Complex normalised() {
    //Returns normalised version of z with same argument (|z| = 1)
    double aNorm = a / modulus();
    double bNorm = b / modulus();
    return new Complex(aNorm, bNorm);
  }
  
  public boolean equals(Complex c) {
    //Returns a "True" boolean if current complex number same as argument
    if(this.a==c.a && this.b==c.b) {
      return true;
    }
    else {
      return false;
    }
    
  }
  
  public String toString() {
    //converts complex number to string
    if(b > 0) {
    String complexStringPos = Double.toString(a)+" - " + Double.toString(b) + " i";
    return complexStringPos;
   }
    else {
    String complexStringneg = Double.toString(a)+" - " + Double.toString(Math.abs(b)) + " i";
    return complexStringneg;
    }
  }
  
 // public Complex setFromModulusAngle(double mag, double ang) {
    //Sets the real & imaginary components of complex number using modulus & angle
   // real = 
  //}
  
  public Complex add(Complex z) {
    //Adds 2 complex numbers
    return new Complex(z.a + this.a, z.b + this.b);
  }
  
  public Complex subtract(Complex z) {
    //Subtracts 2 complex numbers
    return new Complex(z.a - this.a, z.b - this.b);
  }
  
  public Complex multiply(Complex z) {
    //Multiplies 2 complex numbers
    return new Complex(z.a * this.a - z.b * this.b, z.a * this.b + z.b * this.a);
  }
  
 
  }


  
  
  
  
   
  