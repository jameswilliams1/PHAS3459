package module2;

public class FallingParticle {
  //Represents a particle falling through fluid
  double m; //Particle mass in kg
  double d; //Fluid drag coefficient
  double t = 0; //Time since particle was dropped
  double z; //Vertical position of particle from vessel base
  double h; //Initial height of particle from vessel base
  double v; //Particle Velocity measured upwards from vessel
  final double g = 9.81; //Acceleration due to gravity in m/s
  
  public FallingParticle(double mass, double drag) {
    m = mass;
    d = drag;
  }
  
  
  

}
