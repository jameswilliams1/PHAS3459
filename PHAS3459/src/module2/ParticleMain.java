package module2;

public class ParticleMain {

  public static void main(String[] args) {
    
    FallingParticle particle = new FallingParticle(5.2, 3.6);
    particle.setH(10);
    
    particle.drop(0.5);
    System.out.println("deltaT = 0.5s:");
    System.out.println("Time taken was " + particle.getT() + " s");
    System.out.println("Final velocity was " + particle.getV() + " m/s");
    System.out.println();
    
    particle.drop(0.1);
    System.out.println("deltaT = 0.1 s:");
    System.out.println("Time taken was " + particle.getT() + " s");
    System.out.println("Final velocity was " + particle.getV() + " m/s");
    System.out.println();
    
    particle.drop(0.01);
    System.out.println("deltaT = 0.01 s:");
    System.out.println("Time taken was " + particle.getT() + " s");
    System.out.println("Final velocity was " + particle.getV() + " m/s");
    System.out.println();
    
    particle.drop(0.001);
    System.out.println("deltaT = 0.001 s:");
    System.out.println("Time taken was " + particle.getT() + " s");
    System.out.println("Final velocity was " + particle.getV() + " m/s");
    System.out.println();
    
    particle.drop(0.0001);
    System.out.println("deltaT = 0.0001 s:");
    System.out.println("Time taken was " + particle.getT() + " s");
    System.out.println("Final velocity was " + particle.getV() + " m/s");
    
    System.out.println();
    System.out.println("Increasing the number of iterations (by reducing deltaT) gives an increasingly more accurate result for both final time and velocity.");
  }

}
