package module3;

public class TestExceptions {

  public static void main(String[] args) {

    Complex z1 = new Complex(0, 0);
    Complex z2 = new Complex(1, 1);
    System.out.println("z1 = " + z1);
    System.out.println("z2 = " + z2);
    System.out.println("z1 normalised:");
    try {
      System.out.println(z1.normalised());
    } 
    catch (Exception e) {
      System.out.println(e);
    }
    System.out.println("z2/z1:");
    try {
      System.out.println(Complex.divide(z2, z1));
    } 
    catch (Exception e) {
      System.out.println(e);
    }

    System.out.println();
    ThreeVector vectorA = new ThreeVector(0, 0, 0);
    ThreeVector vectorB = new ThreeVector(1, 1, 1);
    System.out.println("Vector A = " + vectorA);
    System.out.println("Vector B = " + vectorB);
    System.out.println("Unit vector of vectorA:");
    try {
      System.out.println(vectorA.unitVector());
    } 
    catch (Exception e) {
      System.out.println(e);
    }
    System.out.println("Angle between vectorB and vectorA:");
    try {
      System.out.println(vectorA.angle(vectorB));
    } 
    catch (Exception e) {
      System.out.println(e);
    }

    System.out.println(FallingParticle.g);
    FallingParticle particle = FallingParticle
    

    
    
    
    


   


  }

}
