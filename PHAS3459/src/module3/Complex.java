package module3;

public class Complex {
  // Represents real (real) and imaginary (imag) components of complex number
  private double real;
  private double imag;

  public Complex() {
    this.real = 0.0;
    this.imag = 0.0;
  }

  public Complex(double real, double imag) {
    this.real = real;
    this.imag = imag;
  }

  public void setReal(double real) {
    // Sets real component of complex number
    this.real = real;
  }

  public void setImag(double imag) {
    // Sets imaginary component of complex number
    this.imag = imag;
  }

  public double real() {
    // returns real component of complex number
    return this.real;
  }

  public double imag() {
    // returns imaginary component of complex number
    return this.imag;
  }

  public double modulus() {
    // Modulus |z| = (a^2 + b^2)^0.5) for z = a + ib
    return Math.sqrt(Math.pow(this.real, 2) + Math.pow(this.imag, 2));
  }

  public double angle() {
    // Arg(z) = Arctan(b/a) for z = a + ib
    return Math.atan(this.imag / this.real);
  }

  public Complex conjugate() {
    // Returns complex conjuagte z* = a - ib for z = a + ib
    return new Complex(this.real, -this.imag);
  }

  public Complex normalised() {
    // Returns normalised version of z with same argument (|z| = 1)
    double realNorm = real / modulus();
    double imagNorm = imag / modulus();
    return new Complex(realNorm, imagNorm);
  }

  public boolean equals(Complex c) {
    // Returns a "True" boolean if current complex number same as argument
    if (this.real == c.real && this.imag == c.imag) {
      return true;
    } else {
      return false;
    }

  }

  public String toString() {
    // converts complex number to string
    String complexString;
    if (imag >= 0) {
      complexString = Double.toString(real) + " + " + Double.toString(imag) + " i";
    } else {
      complexString = Double.toString(real) + " - " + Double.toString(Math.abs(imag)) + " i";
    }
    return complexString;
  }

  public void setFromModulusAngle(double mag, double ang) {
    // real = mag*cos(ang) & imag = mag*sin(ang) for complex number z =
    // mag*e^(i*ang)
    real = mag * Math.cos(ang);
    imag = mag * Math.sin(ang);
  }

  public static Complex add(Complex z1, Complex z2) {
    // z1 + z2 = Re(z1) + Re(z2) + i(Im(z1) + Im(z2))
    return new Complex(z1.real + z2.real, z1.imag + z2.imag);
  }

  public static Complex subtract(Complex z1, Complex z2) {
    // z1 - z2 = Re(z1) - Re(z2) + i(Im(z1) - Im(z2))
    return new Complex(z1.real - z2.real, z1.imag - z2.imag);
  }

  public static Complex multiply(Complex z1, Complex z2) {
    // z1 * z2
    return new Complex(z1.real * z2.real - z1.imag * z2.imag, z1.real * z2.imag + z1.imag * z2.real);
  }

  public static Complex divide(Complex z1, Complex z2) {
    // z1 / z2
    double numerator = (z1.real * z2.real + z1.imag * z2.imag) / (Math.pow(z2.real, 2) + Math.pow(z2.imag, 2));
    double denominator = (z1.imag * z2.real - z1.real * z2.imag) / (Math.pow(z2.real, 2) + Math.pow(z2.imag, 2));
    return new Complex(numerator, denominator);
  }

  public static Complex ONE = new Complex(1, 0);
  public static Complex ZERO = new Complex(0, 0);
  public static Complex I = new Complex(0, 1);
}